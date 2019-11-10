class GreedKtTest extends spock.lang.Specification {

    def "Score"() {
        expect:
        new Greed().score(dies) == score

        where:
        dies               | score
        [5]                | 50
        [1]                | 100
        [1, 1, 1]          | 1000
        [2, 2, 2]          | 200
        [3, 3, 3]          | 300
        [4, 4, 4]          | 400
        [1, 5]             | 150
        [1, 6]             | 100
        [6, 6, 1]          | 100
        [1, 6, 6]          | 100
        [2, 2, 2, 2]       | 400
        [2, 2, 2, 2, 2]    | 800
        [2, 2, 2, 2, 2, 2] | 1600
        [1, 2, 3, 4, 5, 6] | 1200
        [1, 1, 2, 2, 4, 4] | 800
    }
}
