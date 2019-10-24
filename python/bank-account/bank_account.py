from threading import Lock


class BankAccount(object):
    def __init__(self):
        self.lock = Lock()
        self.balance = None
        self.active = False

    def get_balance(self):
        with self.lock:
            if self.active:
                return self.balance
            else:
                raise ValueError("Account is not open.")

    def open(self):
        with self.lock:
            if not self.active:
                self.active = True
                self.balance = 0
            else:
                raise ValueError("Account is already open.")

    def deposit(self, amount):
        with self.lock:
            if amount < 0:
                raise ValueError("Cannot withdraw a negative amount.")

            if self.active:
                self.balance += amount
            else:
                raise ValueError("Account is not open.")

    def withdraw(self, amount):
        with self.lock:
            if amount < 0:
                raise ValueError("Cannot withdraw a negative amount.")

            if self.active:
                if self.balance >= amount:
                    self.balance -= amount
                else:
                    raise ValueError("Insufficient funds.")
            else:
                raise ValueError("Account is not open.")

    def close(self):
        with self.lock:
            if self.active:
                self.active = False
                self.balance = 0
            else:
                raise ValueError("Account is not open.")
