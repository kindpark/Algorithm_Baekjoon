# [Silver II] Assistance Required - 6542 

[문제 링크](https://www.acmicpc.net/problem/6542) 

### 성능 요약

메모리: 102764 KB, 시간: 904 ms

### 분류

자료 구조, 구현, 연결 리스트, 시뮬레이션

### 제출 일자

2024년 6월 10일 19:20:10

### 문제 설명

<p>After the 1997/1998 Southwestern European Regional Contest (which was held in Ulm) a large contest party took place. The organization team invented a special mode of choosing those participants that were to assist with washing the dirty dishes. The contestants would line up in a queue, one behind the other. Each contestant got a number starting with 2 for the first one, 3 for the second one, 4 for the third one, and so on, consecutively.</p>

<p>The first contestant in the queue was asked for his number (which was 2). He was freed from the washing up and could party on, but every second contestant behind him had to go to the kitchen (those with numbers 4, 6, 8, etc). Then the next contestant in the remaining queue had to tell his number. He answered 3 and was freed from assisting, but every third contestant behind him was to help (those with numbers 9, 15, 21, etc). The next in the remaining queue had number 5 and was free, but every fifth contestant behind him was selected (those with numbers 19, 35, 49, etc). The next had number 7 and was free, but every seventh behind him had to assist, and so on.</p>

<p>Let us call the number of a contestant who does not need to assist with washing up a lucky number. Continuing the selection scheme, the lucky numbers are the ordered sequence 2, 3, 5, 7, 11, 13, 17, etc. Find out the lucky numbers to be prepared for the next contest party.</p>

### 입력 

 <p>The input contains several test cases. Each test case consists of an integer <em>n</em>. You may assume that <em>1<=n<=3000</em>. A zero follows the input for the last test case.</p>

### 출력 

 <p>For each test case specified by <em>n</em> output on a single line the <em>n</em>-th lucky number.</p>

