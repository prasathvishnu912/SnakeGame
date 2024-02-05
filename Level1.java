package com.game;

import java.util.Scanner;

public class Level1 {

	static Scanner sc = new Scanner(System.in);
	int[][] snakeInx;
	int[][] ladderInx;

	int rotateDice() {
		int n = (int) (Math.random() * 6) + 1;
		return n;
	}

	public static void main(String[] args) {

		Level1 gL1 = new Level1();

		System.out.println("Enter Board size: ");
		int size = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter number of snakes:");
		int sC = sc.nextInt();
		gL1.getSnakeIndex(sC);

		System.out.println("Enter number of ladders:");
		int lC = sc.nextInt();
		gL1.getLadderIndex(lC);

		gL1.getResult(size);

	}

	private void getResult(int n) {

		int startInx = 0;

		int count = 0;

		while (count < 100) {

			if (startInx >= n * n) {
				System.out.println("Mani wins in " + count + " th time dice Rotation");
				break;
			} else {
				int diceV = rotateDice();

				for (int[] arr : snakeInx) {
					if ((startInx + diceV) == arr[1]) {
						System.out.println("Mani rolled at " + diceV + " and caught by snake moved from " + (startInx+diceV)
								+ " to " + arr[0] + ".");
						startInx = arr[0];
						count++;
						continue;
					}
				}
				for (int[] arr : ladderInx) {
					if ((startInx + diceV) == arr[0]) {
						System.out.println("Mani rolled at " + diceV + " and find ladder moved from " + (startInx+diceV)
								+ " to " + arr[1] + ".");
						startInx = arr[1];
						count++;
						continue;
					}
				}

				System.out.println("Mani rolled at " + diceV + " and moved from" + startInx + " to " + (startInx+diceV) + ".");
				startInx += diceV;
				count++;
			   try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}

	}

	private int[][] getSnakeIndex(int n) {

		snakeInx = new int[n][2];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter index of snake: tail head");

			int tail = sc.nextInt();
			int head = sc.nextInt();

			snakeInx[i][0] = tail;
			snakeInx[i][1] = head;
			sc.nextLine();

		}
		return snakeInx;
	}

	private int[][] getLadderIndex(int n) {

		// TODO Auto-generated method stub

		ladderInx = new int[n][2];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter index of Ladder: bottom top");

			int tail = sc.nextInt();
			int head = sc.nextInt();

			ladderInx[i][0] = tail;
			ladderInx[i][1] = head;
			sc.nextLine();

		}

		return ladderInx;
	}

}
