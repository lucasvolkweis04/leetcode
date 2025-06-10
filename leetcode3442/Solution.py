from collections import Counter

def max_difference(s: str) -> int:
    # Step 1: Count frequencies of each character
    freq_map = Counter(s)

    # Step 2: Separate frequencies into odd and even lists
    odd_freqs = []
    even_freqs = []

    for freq in freq_map.values():
        if freq % 2 == 1:
            odd_freqs.append(freq)
        else:
            even_freqs.append(freq)

    # Step 3: Compute maximum difference between odd and even frequencies
    max_diff = float('-inf')
    for odd in odd_freqs:
        for even in even_freqs:
            max_diff = max(max_diff, odd - even)

    return max_diff

# Test examples
print(max_difference("aaaaabbc"))   # Output: 3
print(max_difference("abcabcab"))   # Output: 1