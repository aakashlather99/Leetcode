class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        lower = 0
        upper = 0
        
        for char in word:
            if char.islower():
                lower |= 1 << (ord(char) - 97)
            else:
                upper |= 1 << (ord(char) - 65)
                
        return (lower & upper).bit_count()