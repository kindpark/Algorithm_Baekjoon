seq1 = [''] + list(input())
seq2 = [''] + list(input())

row, col = len(seq1), len(seq2)
arr = [[0 for _ in range(col)] for _ in range(row)]
for i in range(1, row):
    for j in range(1, col):
        if seq1[i] == seq2[j]:
            arr[i][j] = arr[i-1][j-1] + 1
        else:
            arr[i][j] = max(arr[i-1][j], arr[i][j-1])

lcs_len = arr[row-1][col-1]
print(lcs_len)
lcs = ''
i, j = row-1, col-1
while i > 0 and j > 0:
    if seq1[i] == seq2[j]:
        lcs = seq1[i] + lcs
        if len(lcs) == lcs_len:
            print(lcs)
            break
        i -= 1
        j -= 1
    else:
        if arr[i-1][j] > arr[i][j-1]:
            i -= 1
        else:
            j -= 1