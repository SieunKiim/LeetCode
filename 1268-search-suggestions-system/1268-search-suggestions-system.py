class Solution(object):
    def suggestedProducts(self, products, searchWord):
        """
        :type products: List[str]
        :type searchWord: str
        :rtype: List[List[str]]
        """
        result = []
        products.sort()
        prefix = ''
        for i in searchWord:
            temp = []
            prefix += i
            for p in products:
                if prefix == p[:len(prefix)]:
                    temp.append(p)
                if len(temp) == 3:
                    break

            result.append(temp)
        return result