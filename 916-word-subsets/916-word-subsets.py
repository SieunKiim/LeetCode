from collections import defaultdict
class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        def count(word):
            arr = [0] * 26
            for letter in word:
                arr[ord(letter) - ord('a')] += 1
            return arr

        check = [0] * 26
        for b in words2:
            for i, c in enumerate(count(b)):
                check[i] = max(check[i], c)

        result = []
        for a in words1:
            if all(x >= y for x, y in zip(count(a), check)):
                result.append(a)
        return result