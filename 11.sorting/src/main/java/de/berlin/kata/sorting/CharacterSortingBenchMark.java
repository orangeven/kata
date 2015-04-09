package de.berlin.kata.sorting;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author weng
 *         created: 08.04.15 - 17:09
 */
public class CharacterSortingBenchMark {


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(CharacterSortingBenchMark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    private static final String inputText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi imperdiet, diam at iaculis pretium, " +
            "ligula arcu iaculis nibh, sit amet fringilla sem ante ut nisi. Vestibulum ultricies molestie mi ut tristique. Donec iaculis orci id " +
            "pellentesque vulputate. Integer scelerisque cursus nibh, ac auctor sem suscipit tincidunt. In mollis lorem ante, non finibus magna " +
            "vestibulum nec. Aenean sodales velit nec tellus condimentum, at lobortis lectus auctor. Mauris ut neque maximus ligula viverra suscipit " +
            "sed quis quam. Morbi faucibus odio diam, at commodo nisl mattis at.  \n" +
            "Fusce sit amet lobortis eros, eget cursus lacus. Sed a sapien imperdiet, aliquet diam non, gravida orci. Ut ut maximus turpis. Aliquam " +
            "cursus erat eget dui venenatis rhoncus. Nullam iaculis, velit quis porttitor laoreet, ligula mi blandit odio, aliquet imperdiet dui est " +
            "viverra velit. Integer nec erat lorem. Suspendisse aliquam nisi ac lectus ultrices, quis tristique sem volutpat. Duis sed rhoncus felis." +
            " Maecenas efficitur orci a dui tristique, ultricies tempor tortor ultricies. Phasellus finibus vehicula lorem quis lobortis. Nulla vel " +
            "metus nec nisl lobortis ullamcorper. Morbi lacus nibh, efficitur ac leo ac, pellentesque aliquam erat. Mauris fermentum tristique enim, " +
            "eget fringilla tellus tincidunt at.\n" +
            "\n" +
            "Donec dapibus mattis odio ut cursus. Phasellus diam enim, consectetur ut luctus eget, rhoncus ut sapien. Vestibulum congue urna id tincidunt" +
            " aliquet. Donec nunc quam, porta non nibh at, sagittis feugiat metus. Vestibulum orci sapien, molestie vel placerat et, interdum fringilla" +
            " mauris. Donec rhoncus lacus et maximus sagittis. Pellentesque luctus nisl id purus feugiat, vel vehicula nisl elementum. Duis eget dui rutrum" +
            " massa dignissim vehicula vel sed sem. Morbi hendrerit condimentum felis, et cursus ante interdum ut. Curabitur at diam ac tortor molestie maximus" +
            " sit amet eu metus. Integer tempor, orci in vulputate consequat, arcu diam rhoncus tortor, et porta libero justo volutpat metus.\n" +
            "\n" +
            "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam dictum malesuada purus sit amet efficitur." +
            " Aliquam quis est a nisl convallis elementum. Mauris ultricies accumsan enim, et dictum dolor condimentum vitae. Mauris iaculis diam sed " +
            "fringilla posuere. Proin pharetra, quam ac faucibus faucibus, neque sem pretium quam, eu faucibus nisi dolor et neque. Aenean a aliquet nibh," +
            " id viverra nisl. Nam placerat maximus luctus. Vestibulum a lectus sed purus eleifend pretium ut quis ex. Morbi sodales sagittis rhoncus. Morbi" +
            " mauris tortor, blandit vel faucibus et, consectetur non est. Quisque dignissim dignissim sollicitudin. Ut mi lorem, luctus nec mi et, fermentum" +
            " molestie augue.\n" +
            "\n" +
            "Cras a sollicitudin tellus, vel efficitur nulla. Fusce ultrices, elit non accumsan tempor, est justo euismod odio, quis finibus magna mauris sit" +
            " amet purus. Curabitur elementum mollis nisi, ac iaculis nunc blandit in. Maecenas vel mauris mattis, convallis est eget, sollicitudin felis. Quisque" +
            " purus ex, sagittis placerat velit vel, sodales hendrerit mi. Morbi vulputate est enim, vitae mollis lacus fringilla ac. Mauris rhoncus vitae ligula" +
            " sit amet malesuada. Sed vitae eleifend ex. ";

    @Benchmark
    public void testSortingCharacters() {
        new CharacterSorting().sort(inputText);
    }

    @Benchmark
    public void testQuickSortingCharacters() {
        new CharacterQuickSorting().sort(inputText);
    }


}
