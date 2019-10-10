from datetime import timedelta

def add_gigasecond(birth_date):
    '''
    Calculate the moment when someone has lived for 10^9 seconds.
    
    Input: birth_date (datetime): date of birth of person to calculate
    
    Returns: point when person has lived for a gigasecond (datetime)
    
    '''
    
    GIGASECOND = 1000000000
       
    return birth_date + timedelta(seconds=GIGASECOND)
