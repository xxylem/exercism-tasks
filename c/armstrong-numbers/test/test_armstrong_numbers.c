#include "vendor/unity.h"
#include "../src/armstrong_numbers.h"

void setUp(void)
{
}

void tearDown(void)
{
}

static void test_count_numbers(void)
{
	TEST_ASSERT_EQUAL_INT(1, count_number_of_digits(0));
	TEST_ASSERT_EQUAL_INT(1, count_number_of_digits(1));
	TEST_ASSERT_EQUAL_INT(1, count_number_of_digits(2));
	TEST_ASSERT_EQUAL_INT(1, count_number_of_digits(3));
	TEST_ASSERT_EQUAL_INT(1, count_number_of_digits(4));
	TEST_ASSERT_EQUAL_INT(2, count_number_of_digits(10));
	TEST_ASSERT_EQUAL_INT(2, count_number_of_digits(13));
	TEST_ASSERT_EQUAL_INT(2, count_number_of_digits(54));
	TEST_ASSERT_EQUAL_INT(2, count_number_of_digits(99));
	TEST_ASSERT_EQUAL_INT(5, count_number_of_digits(94219));
}

static void test_zero_is_an_armstrong_number(void)
{
   TEST_ASSERT_TRUE(is_armstrong_number(0));
}

static void test_single_digit_numbers_are_armstrong_numbers(void)
{
   TEST_ASSERT_TRUE(is_armstrong_number(5));
}

static void test_there_are_no_two_digit_armstrong_numbers(void)
{
   TEST_ASSERT_FALSE(is_armstrong_number(10));
}

static void test_three_digit_number_that_is_an_armstrong_number(void)
{
   TEST_ASSERT_TRUE(is_armstrong_number(153));
}

static void test_three_digit_number_that_is_not_an_armstrong_number(void)
{
   TEST_ASSERT_FALSE(is_armstrong_number(100));
}

static void test_four_digit_number_that_is_an_armstrong_number(void)
{
   TEST_ASSERT_TRUE(is_armstrong_number(9474));
}

static void test_four_digit_number_that_is_not_an_armstrong_number(void)
{
   TEST_ASSERT_FALSE(is_armstrong_number(9475));
}

static void test_seven_digit_number_that_is_an_armstrong_number(void)
{
   TEST_ASSERT_TRUE(is_armstrong_number(9926315));
}

static void test_seven_digit_number_that_is_not_an_armstrong_number(void)
{
   TEST_ASSERT_FALSE(is_armstrong_number(9926314));
}

int main(void)
{
   UnityBegin("test/test_armstrong_numbers.c");

   RUN_TEST(test_count_numbers);
   RUN_TEST(test_zero_is_an_armstrong_number);
   RUN_TEST(test_single_digit_numbers_are_armstrong_numbers);
   RUN_TEST(test_there_are_no_two_digit_armstrong_numbers);
   RUN_TEST(test_three_digit_number_that_is_an_armstrong_number);
   RUN_TEST(test_three_digit_number_that_is_not_an_armstrong_number);
   RUN_TEST(test_four_digit_number_that_is_an_armstrong_number);
   RUN_TEST(test_four_digit_number_that_is_not_an_armstrong_number);
   RUN_TEST(test_seven_digit_number_that_is_an_armstrong_number);
   RUN_TEST(test_seven_digit_number_that_is_not_an_armstrong_number);

   return UnityEnd();
}
