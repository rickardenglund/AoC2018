package Advent_of_code_2018.days.day2;

import Advent_of_code_2018.days.Day;

import java.util.*;

public class Day2 implements Day {

    @Override
    public Object getResultP1(String input) {
        String[] rows = input.split("\n");
        int twos = 0;
        int threes = 0;

        for (var row : rows) {
            Map<String, Integer> countMap = countChars(row);
            if (count(2, countMap) > 0) twos++;
            if (count(3, countMap) > 0) threes++;
        }
        return twos * threes;
    }

    public int count(Integer i, Map<String, Integer> countMap) {
        int n = 0;
        for (String key : countMap.keySet()) {
            if (countMap.get(key).equals(i)) {
                n++;
            }
        }
        return n;
    }

    public Map<String, Integer> countChars(String str) {
        var result = new HashMap<String, Integer>();
        var letters = str.split("");

        for (var letter : letters) {
            result.merge(letter, 1, (a, b) -> a + b);
        }
        return result;
    }

    @Override
    public Object getResultP2(String input) {
        List<String> boxIds = Arrays.asList(input.split("\n"));

        for (var id1 : boxIds) {
            for (var id2 : boxIds) {
                if (isDiffByOne(id1, id2)) {
                    return commonString(id1, id2);
                }
            }
        }

        return null;
    }

    public String commonString(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (a.substring(i, i + 1).equals(b.substring(i, i + 1))) {
                sb.append(a, i, i + 1);
            }
        }
        return sb.toString();
    }

    public boolean isDiffByOne(String a, String b) {
        int diffs = 0;
        for (int i = 0; i < a.length(); i++) {
            if (!a.substring(i, i + 1).equals(b.substring(i, i + 1))) diffs++;
        }
        return diffs == 1;
    }

    @Override
    public int getDay() {
        return 2;
    }

    @Override
    public String getInput1() {
        return "kbqwtcvzgumhpwelrnaxydpfuj\n" +
                "kbqwtcvzgsmhpoelryaxydiqij\n" +
                "kbqwpcvzssmhpoelgnaxydifuj\n" +
                "kbqgtcvxgsmhpoalrnaxydifuj\n" +
                "kbqwtcvygsmhpoelrnaxydiaut\n" +
                "kbqwtcvjgsmhpoelrnawydzfuj\n" +
                "kbqftcvzgsmhpoeprnaxydifus\n" +
                "rbqwtcgzgsxhpoelrnaxydifuj\n" +
                "kbqwtlvzgvmhpoelrnaxkdifuj\n" +
                "kbqwtcvzgsmhpolqrnaxydifub\n" +
                "kbqbtcqzgsmhposlrnaxydifuj\n" +
                "kbqwmcvzgswhpoelxnaxydifuj\n" +
                "kbqwtyvzgsmhkoelrnsxydifuj\n" +
                "khqwtcvzgsmhqoelinaxydifuj\n" +
                "koqwtcvzcsmhpoelrnaxydizuj\n" +
                "kbqwtcvzlsmhpoezrnaxydmfuj\n" +
                "kbqwtcvzdsmhpoelrjaxydifij\n" +
                "kbqwtcvzgsmhpoelrncxyjifuk\n" +
                "kbtwtcvzgsmhpoelonaxydiwuj\n" +
                "kbqwfcrzgsmhpoelrnaeydifuj\n" +
                "kbqutcvkgsmhpoelrnfxydifuj\n" +
                "kbqwtcvzgsmvvoelrnaxydihuj\n" +
                "kbqwtcvzhymhpoelrnaxydifyb\n" +
                "kbqctcvzgumhpoalrnaxydifuj\n" +
                "kuqktcvzgsmhpoelrnaxydieuj\n" +
                "kbqwtcvzgsmvpozlrnaxydifmj\n" +
                "kbqwtcvzgsmhpojlraaxydiouj\n" +
                "kbqwtcvzgmmhpoelknaxydizuj\n" +
                "kbwwtcvzgsmhpoefrnaxydifij\n" +
                "kbqwucvzgsmhpoelvnahydifuj\n" +
                "kbqwtcvzpsmhpgelrqaxydifuj\n" +
                "kblqtcvzgsmhpoeirnaxydifuj\n" +
                "kbqwtcvzgsmhpovlrnabydifum\n" +
                "kbqwwcvzgsmhpoelrnaoydnfuj\n" +
                "kyqwdcvzgsmhpoelrnaxfdifuj\n" +
                "kbqftcvzgsmxpoelknaxydifuj\n" +
                "kbqwtsvzksmhpoelqnaxydifuj\n" +
                "kbqwtcvzgsmhplelrnauydifux\n" +
                "kbqytcvzgsmhpkelrnaxydefuj\n" +
                "kbqwtcvzgsmjjoelrlaxydifuj\n" +
                "kbqvtcvzgsmhpoelnnaxydafuj\n" +
                "kbqwtcvzgsjhioelrnaxpdifuj\n" +
                "kbqptcvpgsmhpoelrnaxydiful\n" +
                "kbqwjcazgimhpoelrnaxydifuj\n" +
                "kbqxtcvzgwmhpaelrnaxydifuj\n" +
                "kbqwtcezgsmhqoelrnaxydifub\n" +
                "kbqwtcvzgsmhooelynaxydifuf\n" +
                "kbqwtwvzgsmkpoelrnaxrdifuj\n" +
                "nbqwtcvugsmhpoelrnzxydifuj\n" +
                "kbvwqcvzgsmhpoelsnaxydifuj\n" +
                "kbqwtcyzjsmhpoelrnaxymifuj\n" +
                "kbqwtcvzgsmhpoclrnaxykzfuj\n" +
                "kbbwtcvzgsmhyodlrnaxydifuj\n" +
                "kbwwtcvzgsmytoelrnaxydifuj\n" +
                "kbmwtcczgpmhpoelrnaxydifuj\n" +
                "ubqwtcvzgsmmpoblrnaxydifuj\n" +
                "kbqwtcvzgrmhpoelrnaxnrifuj\n" +
                "kbqwhcvzgsmhpoelynaaydifuj\n" +
                "kbqwtcvzgsmtpoelrcpxydifuj\n" +
                "kdqwtchzgsmhpoelrmaxydifuj\n" +
                "qbqrncvzgsmhpoelrnaxydifuj\n" +
                "kbqwtcvzghshpoelrnaxodifuj\n" +
                "kbqwhcvzgsmhpoelknaxydiwuj\n" +
                "ebqwtcvzgsmhpoelrotxydifuj\n" +
                "kbqwacvzusmhpoelryaxydifuj\n" +
                "kbqwtcvggsmhpoelrnaxygifyj\n" +
                "kbqwtcvzgsmhpoelrnaxycwfuo\n" +
                "kzqwzcvzgsmhpoelrxaxydifuj\n" +
                "khqwtcvzgsmhpoelrnaxldifyj\n" +
                "kbqwtbtzgsmhpoelrnaxydifud\n" +
                "gbqwtcvzgqmhpoelrnaxydifrj\n" +
                "kbqdtqvzgwmhpoelrnaxydifuj\n" +
                "kbqwscvzgsmhpoelrpaxypifuj\n" +
                "kmqwtcdzgsmhpoelenaxydifuj\n" +
                "klqwtcvvgsmhpoelrfaxydifuj\n" +
                "kbuwtcvzgsmhpoelrtaxyuifuj\n" +
                "kbqwtcvrgomhpoelrnaxydijuj\n" +
                "kbqwtgvzgsmhzoelrnpxydifuj\n" +
                "kbqltcvzgsmhooeljnaxydifuj\n" +
                "kbqwtcvzgbmxpoelrnaxydivuj\n" +
                "kbqdtcmzgsmhpoelrnaxydmfuj\n" +
                "kbqwtcazgsmhpoplrnacydifuj\n" +
                "kbqztcvegsmhpoelrnvxydifuj\n" +
                "kbqwtcvzgsmhpoecrnaxydzfsj\n" +
                "kbqwtcvzgsmepoelrnaqydifuf\n" +
                "kbqwtcqzgsmhpoelrnoxydivuj\n" +
                "kbqwtcvzgsmhpoeylnaxydhfuj\n" +
                "kbqwtcvfgsmhpoelrnaxgdifyj\n" +
                "kbqwtcvzgsmhnbelrnaxyfifuj\n" +
                "kbqwtcvzgsmhpoelrnaxbdffmj\n" +
                "kwqwtcvogtmhpoelrnaxydifuj\n" +
                "kdqwtcvzggyhpoelrnaxydifuj\n" +
                "kbqwtuvzgtmhpoelrnaxydifxj\n" +
                "kbqctdvzcsmhpoelrnaxydifuj\n" +
                "kbqwtcvzgsmhpoblrniyydifuj\n" +
                "kbqwucvzzsmhpoelrnvxydifuj\n" +
                "kbqwtcvzgslzpoelrnaxydiruj\n" +
                "kbqwtdmzgsmhpwelrnaxydifuj\n" +
                "kbqwtcvzgsmhpoilrnaxqiifuj\n" +
                "kbqwtcvzgsmhpgelrnaxydisnj\n" +
                "kbdwtqvzgsmhpoelrnaxydivuj\n" +
                "kbqvtdvzgsmhpoelrjaxydifuj\n" +
                "kfqwtcvzgsmhpoeurnyxydifuj\n" +
                "kbqwtcvzgsmhpoglrnaxqkifuj\n" +
                "kbqwtcvrgsmhpoelrnajydifnj\n" +
                "xbqwpcvzgjmhpoelrnaxydifuj\n" +
                "kbqwtcvzgsmhpoelrdaxvdihuj\n" +
                "kbuwtcvzssmhpoklrnaxydifuj\n" +
                "kbqwtcvzgqmhpoelrnzxydifbj\n" +
                "kbqwtcvzgsmhsoeoknaxydifuj\n" +
                "kfqltcvzgsmhpoelrnaxydifnj\n" +
                "qbqwtsvzgsmhpoelrnaxodifuj\n" +
                "kbqwwevzgsmypoelrnaxydifuj\n" +
                "kbqwtcuzgimhpoelrnaxydffuj\n" +
                "kxqwlcvzgsmhpoelrnaxyrifuj\n" +
                "nbqwtcvzgsmhpoelryaxyiifuj\n" +
                "kbqwtcvzgsmhhoxlreaxydifuj\n" +
                "mbqwtcvzfsmxpoelrnaxydifuj\n" +
                "kbqwttvzgsmhpoeqrnaxidifuj\n" +
                "kbqwtcvzgamhpielrnaxyiifuj\n" +
                "rfqwtcvzgsmhpoelrnaxydifun\n" +
                "kbpwtqvzgsmbpoelrnaxydifuj\n" +
                "kbqwtcvzgsmhpoqlroaxydifua\n" +
                "hbqwtcvzksmhpoelrnaxydbfuj\n" +
                "kaqutcvzgsmhpoelrnaxydiiuj\n" +
                "kbqctcvzgsnhpoelrcaxydifuj\n" +
                "kbqwtnvzgsmhpoelrnaxydqfoj\n" +
                "kbqwtcvzhsmhpoelrnaxydifyb\n" +
                "ubqwtcvcgsmhooelrnaxydifuj\n" +
                "kbqwtcvrgsmhpoelrnaxtdivuj\n" +
                "kbqwtcvzgsmhplelrnmxydifaj\n" +
                "ebqwlcvzghmhpoelrnaxydifuj\n" +
                "hbqwtcvzgsmhpoelrnaqyeifuj\n" +
                "kbqstcvzgsmeprelrnaxydifuj\n" +
                "kbqwtcvogsthpoelrnnxydifuj\n" +
                "ybqwtcvzgdmhpoelrnaxydufuj\n" +
                "kbqutcvzgsmhpoelrnaxydifgx\n" +
                "kbqwtcvzgsmhpozlunadydifuj\n" +
                "kkqwtcvzgsmhpuefrnaxydifuj\n" +
                "kbqrtcvzgsmhpoelrnaxcdifuq\n" +
                "kbqwtcvzjsmupoelrnaxydiluj\n" +
                "kbqwmcvzgsuhpoelrnaxydifhj\n" +
                "kbqwfcvzgsmhpoelrnaxydkzuj\n" +
                "kbqatcvzgsdhpoeyrnaxydifuj\n" +
                "kbtwtcvzusmhpoelrxaxydifuj\n" +
                "kbqwtcwzgsmhpoelrnaxysofuj\n" +
                "kbqqtcvmgsmhpoevrnaxydifuj\n" +
                "kbqwjcvzgsmhpoelrnaxydhuuj\n" +
                "mbdwtcvzgsmhpoelqnaxydifuj\n" +
                "kbqwtcvlgsmhpoelrdaxydifaj\n" +
                "kbqwtcvzgsmmpoelrlaxydnfuj\n" +
                "kbqwtchfggmhpoelrnaxydifuj\n" +
                "kbqqtcvzgsyhpoelrnaxyoifuj\n" +
                "knqwtcvzqsmupoelrnaxydifuj\n" +
                "kdqdtcvzgsmhpoelrnaxydmfuj\n" +
                "kbqwtcvzgsmhptelrnawyhifuj\n" +
                "kbqwtcvzgrmhpoeqrnaxydifuw\n" +
                "kbnxtcvzgsmhpoelrnauydifuj\n" +
                "kbqwacvsgsmhpoelrnaxydifgj\n" +
                "kbqwtcvzgsmhpperrnaxydifuc\n" +
                "gbqwtcvzgsqhxoelrnaxydifuj\n" +
                "kbqwtcvzgsmhpoeljgaxydifwj\n" +
                "kbqktcvzgsmhpotlrnatydifuj\n" +
                "bbqwtcvzgsmhpoilrnaxydjfuj\n" +
                "kbqwecvdgsmhpoelrnaxypifuj\n" +
                "keqwtcvzgemhpotlrnaxydifuj\n" +
                "kbqptcvzgsmvpoelrnaxydixuj\n" +
                "kbqwbctzgsmhpoelrnaxydifup\n" +
                "kbqwtcvzgszhpbelrnzxydifuj\n" +
                "mbqwtcvtgsmhpoeyrnaxydifuj\n" +
                "kbqwtcvzgsmhqcelrhaxydifuj\n" +
                "kbqotcvzgsmhooelrnazydifuj\n" +
                "kbqwtcvzgsmhpoelmpaxyiifuj\n" +
                "kbqwtcvwgsmypoclrnaxydifuj\n" +
                "kbqwtcvsgskhpoelrnaxykifuj\n" +
                "kbqwtcvzgszvpoelrnwxydifuj\n" +
                "kbqwtcvzgsmhpoejonaxydrfuj\n" +
                "kbqwtcvzgsmhkoelrnazyqifuj\n" +
                "kbzwtzvzgsmhptelrnaxydifuj\n" +
                "kbqwtcdzgsmhptelrnaxydiduj\n" +
                "kbqwtcvzgamhpoelrnakyzifuj\n" +
                "kbqwtcvzgsmhpoeonnaxydifxj\n" +
                "kbqwtcvzgsmhpoeranaxydifej\n" +
                "kbqwscvzgsmhpoelunaxydimuj\n" +
                "cbqwtcvzgsmhpoelrdaxydefuj\n" +
                "vbqwtcjzgsmhpoelrnaxydifua\n" +
                "kmqwtcvzksmhpoeljnaxydifuj\n" +
                "kbqwtcvzgsmppojlrnasydifuj\n" +
                "kaqwtcvfgsmhpoelrnaxydiauj\n" +
                "khqwccvzgsmhpoelrnaxydifud\n" +
                "vbqwtcvzrsmhpoelrhaxydifuj\n" +
                "kuqwtcvzgsmhpoelgnaiydifuj\n" +
                "kbqwtcvzdsmhpbelvnaxydifuj\n" +
                "kbowtcvzgnmhpoelrfaxydifuj\n" +
                "kbqwtcvsgsmhfoejrnaxydifuj\n" +
                "kbqwtcvzgskhtoelrnxxydifuj\n" +
                "kbqwtcvzgtmhpoevrnaxydivuj\n" +
                "bbqptcgzgsmhpoelrnaxydifuj\n" +
                "kbqwtpvzgsmnpoelhnaxydifuj\n" +
                "kbqwtovzgsmmpoelrnaxydifuw\n" +
                "kbqwtcvzgsihpwelrnaxydsfuj\n" +
                "kbqwtcvzggmhpollrnaxydifsj\n" +
                "kbqwtcjzgsmhpoelrnaxyxifub\n" +
                "ebqwtcvzgsmzpoelrnaaydifuj\n" +
                "kbqwtcvzusmhpoelrnqxydijuj\n" +
                "obqwtcvzgsghpoelrnaxydifkj\n" +
                "kbrwtcvzmdmhpoelrnaxydifuj\n" +
                "kbqwtcvzxsmhpoblrnhxydifuj\n" +
                "kbqwacvzgsahpoelrnaxydiguj\n" +
                "kyqwtcvzgsmipoelrnlxydifuj\n" +
                "kbbwtcvzgsmhboelpnaxydifuj\n" +
                "kbqwtcvzgsmhpoelrnaxhdosuj\n" +
                "kbqwtgvzgxmhpoelrnaxyrifuj\n" +
                "pbqwtsvzgsmhpoelrnabydifuj\n" +
                "kbqrtcvzgsmhpsblrnaxydifuj\n" +
                "kbqwtcvzgsmhpoexrnaaycifuj\n" +
                "kbqxtcvzgsjhkoelrnaxydifuj\n" +
                "kbqwtcvzgsmhpxelrnaxydifby\n" +
                "lbxwtcvzgsmdpoelrnaxydifuj\n" +
                "kbqwtcczgsmhpoklrnzxydifuj\n" +
                "zbqwtcvzgsmhpoelrbaxydifui\n" +
                "krqwtcvzbsmhpoelrjaxydifuj\n" +
                "kbkwtcvzgsmhpoelrnaxydiacj\n" +
                "kbqwtcvzgszhpseprnaxydifuj\n" +
                "kbxwtcvzxsmhpoesrnaxydifuj\n" +
                "kbqwdcvzgsmhpoelrbaxygifuj\n" +
                "kbqwthkzgsmhhoelrnaxydifuj\n" +
                "klqwtchzgamhpoelrnaxydifuj\n" +
                "obqwtcvzgsvcpoelrnaxydifuj\n" +
                "kblwtcvzgsmhpoelrnanydifuw\n" +
                "kbqwtrvzgsmhpoelynaxydifug\n" +
                "kbqwtcvzgsmhcoelmnaxydkfuj\n" +
                "kbqwtcvzgsmhpotlqoaxydifuj\n" +
                "kaqatcvzgsmhpoelrnaxyiifuj\n" +
                "kbqttcvwgsmhpoelrnaxydifgj\n" +
                "kpqwtcvzgsmhpwelynaxydifuj\n" +
                "kbqwucvzgsmhpyelrnaxyxifuj\n" +
                "kbqwucvzgsmhprelrnaxyfifuj\n" +
                "kbqwthvzgsmhphelrnaxylifuj\n" +
                "kbqwtcvzosmhdoelrnaxwdifuj\n" +
                "kbqwtxvsgsphpoelrnaxydifuj\n" +
                "koqwtcvfghmhpoelrnaxydifuj\n" +
                "kbtwicvzpsmhpoelrnaxydifuj\n" +
                "kbawtcvzgsmhmoelrnaxyiifuj\n" +
                "kbqwtcvzgslhpbelrnaxydifuk\n" +
                "kbqttcvzgsmypoelrnaxydifua\n" +
                "kbqwtcvrgqmhpnelrnaxydifuj\n" +
                "kbqwtcvzghmhpoekpnaxydifuj\n" +
                "kbqwtcvzgsmupoelrnaxidifui\n" +
                "kbqwtcvzgsmhpbelrnaxrdifux";
    }

}
