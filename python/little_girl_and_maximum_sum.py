import sys

input = sys.stdin.readline

n, q = map(int, input().split())
a = list(map(int, input().split()))

c = [0] * (n + 2)

for _ in range(q):
    l, r = map(int, input().split())
    c[l - 1] += 1
    c[r] -= 1

for i in range(1, n):
    c[i] += c[i - 1]

a.sort()
c[:n].sort()

print(sum(a[i] * c[i] for i in range(n)))