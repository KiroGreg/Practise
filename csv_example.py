from csv import *

famous_methods = [
    ["1. csv.reader(file) - this method reads the contents of a CSV file and returns a list of rows. It allows reading a CSV file line by line."],

    ["2. csv.writer(file) - this method allows writing data to a CSV file. You can pass a list or tuple with data, and it will be written to the file."],

    ["3. csv.DictReader(file) - this method reads the contents of a CSV file and returns a dictionary where keys are column names and values are the values in that column. It allows reading a CSV file as a dictionary."],

    ["4. csv.DictWriter(file, fieldnames) - this method allows writing data to a CSV file as a dictionary. You can pass a list of column names to the fieldnames argument, and then pass a dictionary where keys are column names and values are the values in that column."],

    ["5. csv.register_dialect(name, dialect) - this method registers a new CSV dialect. Each dialect has its own settings, such as delimiter and quotes. You can use this method to create your own custom dialect."],

    ["6. csv.get_dialect(name) - this method returns a CSV dialect object by its name. You can use it to get the settings of a specific dialect."]
]

with open("csv_methods.csv", "w") as file:
    writer = writer(file)
    writer.writerow([
        "CSV Methods"
    ])
    writer.writerows(famous_methods)

with open("csv_methods.csv", "r") as file:
    reader = reader(file)
    print(*reader)
