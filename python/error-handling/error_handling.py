def handle_error_by_throwing_exception():
    raise Exception("An error has occurred.")


def handle_error_by_returning_none(input_data):
    return input_data == '1' or None


def handle_error_by_returning_tuple(input_data):
    if input_data == '1':
        return True, 1
    return False, None


def filelike_objects_are_closed_on_exception(filelike_object):
    try:
        filelike_object.do_something()
    finally:
        filelike_object.close()
