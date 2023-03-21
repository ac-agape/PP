import os
import tkinter as tk

class Parser:
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))
    A = None
    B = None

    def __init__(self, gui):
        self.gui = gui
        self.gui.title('Lucru pe lista')

        self.gui.geometry("631x269")

        self.integer_list_lbl = tk.Label(master=self.gui,
                                         text="List of integers:")

        self.add_list_btn = tk.Button(master=self.gui,
                                      text="Add list",
                                      command=self.add_list)

        self.filter_odd_btn = tk.Button(master=self.gui,
                                      text="Filter Odd",
                                      command=self.filter_odd)

        self.result_text = tk.Text(master=self.gui, width=50, height=10)

        self.integer_list_text = tk.Text(self.gui, width=50, height=1)
        self.integer_list_text.insert(tk.END, str(list(range(1, 16)))[1:-1])

        # alignment on the grid
        self.integer_list_lbl.grid(row=0, column=0)
        self.integer_list_text.grid(row=0, column=1)
        self.add_list_btn.grid(row=0, column=2)
        self.filter_odd_btn.grid(row=1, column=2)
        self.result_text.grid(row=1, column=1)
        
        self.integer_list = []
        self.result_text.insert('1.0', 'Result...')

        self.gui.mainloop()

    def add_list(self):
        result = self.integer_list_text.get("1.0", tk.END)
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        self.integer_list = result
        print(result)

    def filter_odd(self):
        self.result_text.delete(1.0, 3.0)
        self.result_text.insert('1.0', list(filter(lambda x: x % 2 == 1, self.integer_list)))

if __name__ == '__main__':
    root = tk.Tk()
    root.title('Exemplul 1 cu Tkinter')
    app = Parser(root)
    root.mainloop()
