class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        arr = []
        target = [1]
        used_t = {pattern[0]:1}
        count_t = 1
        for t in range(1, len(pattern)):
            if pattern[t] not in used_t:
                count_t += 1
                used_t[pattern[t]] = count_t
            target.append(used_t[pattern[t]])

        for word in words:
            temp = [1]
            used = {word[0] : 1}
            count = 1
            for w in range(1, len(word)):
                if word[w] not in used:
                    count += 1
                    used[word[w]] = count
                temp.append(used[word[w]])
            if temp == target:
                arr.append(word)
        # print(target)
        return (arr)