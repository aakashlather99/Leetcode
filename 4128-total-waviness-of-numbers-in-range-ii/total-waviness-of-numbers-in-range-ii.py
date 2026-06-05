class Solution:
    def totalWaviness(self, num1: int, num2: int) -> int:
        def solve(n: int) -> int:
            if n <= 0:
                return 0
            s = str(n)
            memo = {}
            
            def dp(idx, is_tight, is_lz, pp_d, p_d):
                if idx == len(s):
                    return 1, 0
                state = (idx, is_lz, pp_d, p_d)
                if not is_tight and state in memo:
                    return memo[state]
                
                limit = int(s[idx]) if is_tight else 9
                t_cnt, t_wav = 0, 0
                
                for d in range(limit + 1):
                    n_tight = is_tight and d == limit
                    n_lz = is_lz and d == 0
                    n_pp = -1 if n_lz else p_d
                    n_p = -1 if n_lz else d
                    
                    add_wav = 0
                    if pp_d != -1 and p_d != -1:
                        if (pp_d < p_d and p_d > d) or (pp_d > p_d and p_d < d):
                            add_wav = 1
                            
                    c, w = dp(idx + 1, n_tight, n_lz, n_pp, n_p)
                    t_cnt += c
                    t_wav += w + add_wav * c
                
                if not is_tight:
                    memo[state] = (t_cnt, t_wav)
                return t_cnt, t_wav
                
            return dp(0, True, True, -1, -1)[1]

        return solve(num2) - solve(num1 - 1)