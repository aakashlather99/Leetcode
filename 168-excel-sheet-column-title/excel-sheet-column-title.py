class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        result = []

        while columnNumber:
            columnNumber -= 1
            result.append(chr(columnNumber % 26 + ord('A')))
            columnNumber //= 26

        return ''.join(reversed(result))