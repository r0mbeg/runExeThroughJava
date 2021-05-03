# runPythonExeThroughJava
**This program:**

- Prompts the user to enter the path to Python executable (to the Python interpreter)

- Starts a new Python process that executes the following command: [Path to Python] -m timeit -r 10, where [Path to Python] is the string that the user entered

- Waiting for the result of the command execution

- During the waiting process, every second the console displays how many seconds have passed since the launch

- After the Python process finishes running, its result is also output to the console
