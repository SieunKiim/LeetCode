<h2><a href="https://leetcode.com/problems/course-schedule-iii/">630. Course Schedule III</a></h2>
<h2>해설</h2>
일단 이야기 하기 편하게 [실행시간, 유통기한] 이라고 생각해보자.

1. 유통기한을 기준으로 정렬을 하는 것은 크게 이질감 없이 다가올 것이다.

2. 처음 시간 0을 기준으로 실행시간들을 하나씩 넣는다.

3. 다음 실행시간을 넣으려 할 떄 유통기한이 지나있다면 당연히 앞에서 필요없는 실행시간을 빼 줘야 한다.
 	- 이 때 당연하게도 가장 실행 시간을 많이 잡아먹는 녀석을 뺼 수록 유리하다.
 	- 큰거 하나 뺴서 하나 들어가면 같은 것 | 큰거 하나 뺴서 뒤에 작은거 두개 이상 들어가면 이득인 시스템
4. 이 때 가장 큰 녀석을 빼기 위해 heapq를 사용한다.

5. 코드를 보고 이해해보자!

<h3>Hard</h3><hr><div><p>There are <code>n</code> different online courses numbered from <code>1</code> to <code>n</code>. You are given an array <code>courses</code> where <code>courses[i] = [duration<sub>i</sub>, lastDay<sub>i</sub>]</code> indicate that the <code>i<sup>th</sup></code> course should be taken <b>continuously</b> for <code>duration<sub>i</sub></code> days and must be finished before or on <code>lastDay<sub>i</sub></code>.</p>

<p>You will start on the <code>1<sup>st</sup></code> day and you cannot take two or more courses simultaneously.</p>

<p>Return <em>the maximum number of courses that you can take</em>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
<strong>Output:</strong> 3
Explanation: 
There are totally 4 courses, but you can take 3 courses at most:
First, take the 1<sup>st</sup> course, it costs 100 days so you will finish it on the 100<sup>th</sup> day, and ready to take the next course on the 101<sup>st</sup> day.
Second, take the 3<sup>rd</sup> course, it costs 1000 days so you will finish it on the 1100<sup>th</sup> day, and ready to take the next course on the 1101<sup>st</sup> day. 
Third, take the 2<sup>nd</sup> course, it costs 200 days so you will finish it on the 1300<sup>th</sup> day. 
The 4<sup>th</sup> course cannot be taken now, since you will finish it on the 3300<sup>th</sup> day, which exceeds the closed date.
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> courses = [[1,2]]
<strong>Output:</strong> 1
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> courses = [[3,2],[4,3]]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= courses.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= duration<sub>i</sub>, lastDay<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
</ul>
</div>
