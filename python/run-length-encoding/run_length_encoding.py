class Message(object):
    def __init__(self, message):
        self.message = message
        self.encoded = False

    def get_message(self):
        return self.message
    
class Encoded_Message(Message):
    def __init__(self, message):
        Message.__init__()
        self.encoded = True
        
    
        
def decode(string):
    '''
    Decodes a string that has been encoded with Run-Length Encoding (RLE)
    
    Input: string: encoded message
    
    Returns: decoded string
    
    '''
    
    


def encode(string):
    '''
    Encodes a string with Run-Length Encoding (RLE)
    
    Input: string: message to be encoded
    
    Returns: encoded string
    
    '''
    
   
        
            
    return current_string
    
    
    
    # 2) next letter is the same - continue incrementing
    
    # 3) next letter is different - cut off where we are