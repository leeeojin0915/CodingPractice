package practice;

import java.util.*;

public class CalcularSettle {

    // 거래 정보 저장
    static Map<String, int[]> transactions = new HashMap<>();
    // id -> [type(0=income,1=expense), amount]
    static Map<String, String> transactionCategory = new HashMap<>();
    // id -> category

    // 카테고리별 income/expense 합계
    static Map<String, long[]> categorySum = new HashMap<>();
    // category -> [incomeSum, expenseSum]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            String[] parts = line.split(" ");
            String cmd = parts[0];

            switch (cmd) {
                case "ADD" -> {
                    String id = parts[1];
                    String type = parts[2];
                    String category = parts[3];
                    long amount = Long.parseLong(parts[4]);

                    transactions.put(id, new int[]{type.equals("income") ? 0 : 1, (int) amount});
                    transactionCategory.put(id, category);

                    long[] sums = categorySum.getOrDefault(category, new long[]{0, 0});
                    if (type.equals("income")) sums[0] += amount;
                    else sums[1] += amount;
                    categorySum.put(category, sums);
                }
                case "DELETE" -> {
                    String id = parts[1];
                    if (transactions.containsKey(id)) {
                        int[] tx = transactions.get(id);
                        String category = transactionCategory.get(id);
                        long[] sums = categorySum.get(category);
                        if (tx[0] == 0) sums[0] -= tx[1]; // income
                        else sums[1] -= tx[1];             // expense
                        transactions.remove(id);
                        transactionCategory.remove(id);
                    }
                }
                case "QUERY" -> {
                    String category = parts[1];
                    long[] sums = categorySum.getOrDefault(category, new long[]{0, 0});
                    long balance = sums[0] - sums[1];
                    sb.append("QUERY ").append(category).append(": ").append(balance).append("\n");
                }
                case "TOP_CATEGORY" -> {
                    int k = Integer.parseInt(parts[1]);
                    // expense 내림차순, 동점이면 카테고리명 사전순
                    List<Map.Entry<String, long[]>> list = new ArrayList<>(categorySum.entrySet());
                    list.sort((a, b) -> {
                        long diff = b.getValue()[1] - a.getValue()[1];
                        if (diff != 0) return diff > 0 ? 1 : -1;
                        return a.getKey().compareTo(b.getKey());
                    });

                    StringBuilder result = new StringBuilder("[");
                    for (int i = 0; i < k; i++) {
                        if (i > 0) result.append(", ");
                        result.append(list.get(i).getKey())
                                .append("=")
                                .append(list.get(i).getValue()[1]);
                    }
                    result.append("]");
                    sb.append("TOP_CATEGORY: ").append(result).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}