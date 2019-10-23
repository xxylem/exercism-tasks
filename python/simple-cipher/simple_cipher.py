import secrets
import string
from itertools import cycle


class Cipher(object):
    def __init__(self, key=None):
        """ Uses key provided or randomly generated key if none provided."""
        if key is None:
            self.key = ''.join(secrets.choice(string.ascii_lowercase) for _ in range(100))
        else:
            self.key = key

    def encode(self, text):
        """ Encodes given text using substitution cipher with self.key."""
        encoded_text = ""
        for (text_letter, key_letter) in zip(text, cycle(self.key)):
            shift = ord(key_letter) - ord('a')
            letter_position = ord(text_letter) - ord('a')
            encoded_text += chr(ord('a') + ((letter_position + shift) % 26))
        return encoded_text

    def decode(self, text):
        """ Decodes given text using substitution cipher with self.key."""
        encoded_text = ""
        for (text_letter, key_letter) in zip(text, cycle(self.key)):
            shift = ord(key_letter) - ord('a')
            letter_position = ord(text_letter) - ord('a')
            encoded_text += chr(ord('a') + ((letter_position - shift) % 26))
        return encoded_text
