import re


class Phone:
    def __init__(self, phone_number):
        m = re.search(
            r'''^(?:\+?1)?\s*
                \(?(?P<area>[2-9]\d\d)\)?
                [. -]*
                (?P<exchange>[2-9]\d\d)
                [. -]*
                (?P<subscriber>\d{4})
                \s*$''',
            phone_number, flags=re.VERBOSE)

        if m is None:
            raise ValueError("Invalid number")

        self.area_code = m.group("area")
        self.exchange_code = m.group("exchange")
        self.subscriber_code = m.group("subscriber")
        self.number = self.area_code + self.exchange_code + self.subscriber_code

    def pretty(self):
        return f"({self.area_code}) {self.exchange_code}-{self.subscriber_code}"
