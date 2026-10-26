my_list = [
    "'r' - Opens file for reading. (Default value)",
    """'w' - Opens file for writing. If the file does not exist, a new one will be created.
    If the file exists, data in it will be overwritten.""",
    "'x' - Opens file for exclusive creation. If the file already exists, the operation will fail.",
    """'a' - Opens file for appending data without erasing previous data.
    Creates a new file if it does not exist.""",
    "'t' - Opens file in text mode. (Default value)",
    "'b' - Opens file in binary mode.",
    "'+' - Allows working with file for both writing and reading."
]

with open("file_with_files_methods.txt", "w") as file:
    file.writelines([item + "\n" for item in my_list])

with open("file_with_files_methods.txt", "r") as file:
    print(*[line for line in file.readlines()])
