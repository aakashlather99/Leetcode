class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        balance = 0
        blank = 0

        for ch in moves:
            if ch == 'L':
                balance -= 1
            elif ch == 'R':
                balance += 1
            else:
                blank += 1

        return abs(balance) + blank