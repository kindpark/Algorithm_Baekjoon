# [Gold V] Coin - 9921 

[문제 링크](https://www.acmicpc.net/problem/9921) 

### 성능 요약

메모리: 14268 KB, 시간: 112 ms

### 분류

너비 우선 탐색, 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 3월 17일 18:03:52

### 문제 설명

<p>A certain currency is issued with N coin denominations.  (That is, the currency has N types of coins.)  Each coin denomination i has a monetary value of v<sub>i</sub> cents and a weight of w<sub>i</sub> grams, 1 ≤ i ≤ N.  Two coin denominations may have the same value or the same weight, but not both.  For given values of V and W, you are to find M, the minimum number of coins needed, such that these M coins have a total monetary value of V cents and a total weight of W grams.  Set M to zero when there is no such a collection of coins.  You may assume an infinite supply of coins for each denomination.</p>

<p>Example 1.  Let the coin denominations be</p>

<table class="table table-bordered td-center table-center-20">
	<thead>
		<tr>
			<th>i</th>
			<th>v<sub>i</sub></th>
			<th>w<sub>i</sub></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>1</td>
			<td>1</td>
		</tr>
		<tr>
			<td>2</td>
			<td>2</td>
			<td>1</td>
		</tr>
		<tr>
			<td>3</td>
			<td>4</td>
			<td>1</td>
		</tr>
		<tr>
			<td>4</td>
			<td>8</td>
			<td>1</td>
		</tr>
		<tr>
			<td>5</td>
			<td>16</td>
			<td>1</td>
		</tr>
		<tr>
			<td>6</td>
			<td>32</td>
			<td>1</td>
		</tr>
		<tr>
			<td>7</td>
			<td>64</td>
			<td>1</td>
		</tr>
		<tr>
			<td>8</td>
			<td>128</td>
			<td>1</td>
		</tr>
	</tbody>
</table>

<p>and V = 141, W = 4.  We have M = 4 because the 4 coins, one from each of the denominations 1, 3, 4, 8, have a monetary value 141 and weight 4.</p>

<p>Example 2.  Let the coin denominations be</p>

<table class="table table-bordered td-center table-center-20">
	<thead>
		<tr>
			<th>i</th>
			<th>v<sub>i</sub></th>
			<th>w<sub>i</sub></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>12</td>
			<td>3</td>
		</tr>
		<tr>
			<td>2</td>
			<td>4</td>
			<td>7</td>
		</tr>
		<tr>
			<td>3</td>
			<td>8</td>
			<td>10</td>
		</tr>
		<tr>
			<td>4</td>
			<td>21</td>
			<td>9</td>
		</tr>
	</tbody>
</table>

<p>For V=11 and W=17, we have M = 0 because obviously there is no such a set of coins.</p>

<ol>
	<li>Read the input to obtain N (1 ≤ N ≤ 20, the number of coin denominations), V (1 ≤ V ≤ 150, the required total monetary value), W (1 ≤ W ≤ 150, the required total weight), the monetary value v<sub>i</sub> (1 ≤ v<sub>i</sub> ≤ 150) and the weight w<sub>i</sub> (1 ≤ w<sub>i</sub> ≤ 150), 1 ≤ i ≤ N, of each denomination.</li>
	<li>Determine M, the minimum number of coins needed to give a total monetary value of V cents and a total weight of W grams.  The value of M should be zero if there are no such coins.</li>
	<li>Write the value of M to the output.</li>
</ol>

### 입력 

 <p>The input file contains N + 1 lines.  The first line consists of the integers N, V and W in that order.  Each of the subsequent N lines consists of 2 integers separated by a space describing one coin denomination: the first integer is the value of the coin in cents and the second integer is the weight of the coin in grams.</p>

### 출력 

 Empty

