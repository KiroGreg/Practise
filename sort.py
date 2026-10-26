mas = []

n = int(input("Enter number of elements : "))
for amount in range(1, n+1):
    element = int(input(f"{amount} element is: "))
    mas.append(element)
print("This is your list: ", mas)
counter = 0
for run in range(1, n):
    print(f"{run} step: ")
    for i in range(n-1):
        if mas[i] > mas[i+1]:
            counter += 1
            mas[i], mas[i+1] = mas[i+1], mas[i]
    print(f"{mas}\nAmount of inversions in this step = {counter}")
