class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        leftCard = (len(cardPoints) - k)
        if leftCard == 0:
            return sum(cardPoints)
        if leftCard == 1:
            return sum(cardPoints) - min(cardPoints)

        temp = cardPoints[:leftCard]
        startSum = sum(temp)
        want = startSum
        # print(startSum)
        for i in range(leftCard, len(cardPoints)):
            # print(i, i - leftCard)
            startSum = startSum + (cardPoints[i] - cardPoints[i - leftCard])
            want = min(want, startSum)
            # print("더한거", cardPoints[i], "  뺀거 ", cardPoints[i - leftCard], "total : ", startSum)

        return sum(cardPoints) - want