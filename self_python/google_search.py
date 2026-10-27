mas = []
search_mas = []
out_mas = []

n = int(input())
for _ in range(n):
    m = str(input())
    mas.append(m)

s = int(input())
for _ in range(s):
    search = str(input())
    search_mas.append(search.lower())

for string in mas:
    if all(query in string.lower() for query in search_mas):
        out_mas.append(string)

print(*out_mas, sep="\n")
