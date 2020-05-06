package com.datastructure.linear.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class StockPriceAggregator {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		HashMap<String, List<Double>> map = new HashMap<>();

		@Override
		public void putNewPrice(String symbol, double price) {
			// YOUR CODE HERE
			List<Double> value = new ArrayList<>();
			if (map.containsKey(symbol)) {
				value = map.get(symbol);
				value.add(price);
				map.put(symbol, value);
			} else {
				value.add(price);
				map.put(symbol, value);
			}
		}

		@Override
		public double getAveragePrice(String symbol) {
			// YOUR CODE HERE
			for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
				if (entry.getKey().equals(symbol)) {
					List<Double> list = entry.getValue();
					int count = list.size();
					Double sum = 0.0;
					Double avg = 0.0;
					for (int i = 0; i < list.size(); i++) {
						sum = sum + list.get(i);
					}
					return sum / count;
				}
			}
			return 0;

		}

		@Override
		public int getTickCount(String symbol) {
			int size = 0;
			for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
				if (entry.getKey().equals(symbol)) {
					List<Double> list = entry.getValue();
					size = list.size();
				}
			}
//			double num = 1.34567;

//	        System.out.format("%.4f", num);
			return size;
			// YOUR CODE HERE
		}
		/*
		 * public int getTickCount(String symbol) { int size=0; for
		 * (Map.Entry<String, List<Double>> entry : map.entrySet()) { if
		 * (entry.getKey().equals(symbol)) { List<Double> list =
		 * entry.getValue(); size= list.size(); } } return size; }
		 */

		public static void main(String[] args) {

			Scanner scanner = new Scanner(System.in);
			while (scanner.hasNext()) {
				final StatisticsAggregator stats = new StatisticsAggregatorImpl();
				final Set<String> symbols = new TreeSet<>();

				String line = scanner.nextLine();
				String[] inputs = line.split(",");
				for (int i = 1; i < inputs.length; ++i) {
					String[] tokens = inputs[i].split(" ");
					final String symbol = tokens[0];
					symbols.add(symbol);
					final double price = Double.parseDouble(tokens[1]);

					stats.putNewPrice(symbol, price);

				}

				for (String symbol : symbols) {
					System.out.println(String.format("%s %.4f %d", symbol, stats.getAveragePrice(symbol),
							stats.getTickCount(symbol)));
				}
			}
			scanner.close();

		}
	}
}
