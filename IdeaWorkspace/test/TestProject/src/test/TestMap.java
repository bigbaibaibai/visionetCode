package test;

import java.util.*;

public class TestMap {

    /**
     * 对给定的数字列列表进⾏行行分组，要求返回的Map中，Key为数字，Value为该数字的List，List的⼤大⼩小与该数字出现的次数⼀一致。 *
     * 例例如，输⼊入的数字集合为:[1, 2, 3, 3, 4, 2]，
     * 那么返回值应为:{1=[1], 2=[2, 2], 3=[3, 3], 4=[4]} *
     *
     * @param numbers 给定的数字集合
     * @return 分组后的Map
     * @throws Exception 异常
     */
    static Map<Integer, List<Integer>> classify(Collection<Integer> numbers){

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (Integer number : numbers) {
            if (map.containsKey(number)) {
                map.get(number).add(number);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(number);
                map.put(number, list);
            }
        }
        return map;
    }

    public static void main(String[] args) {
//        Map<Integer, List<Integer>> classify = classify(Arrays.asList(1, 2, 3, 3, 4, 2));
//        System.out.println(classify);

        System.out.println(Arrays.asList(1,2,3,4,5,6).toString().replaceAll("[\\W^,]",""));

    }

}