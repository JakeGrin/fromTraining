package com.training.sgorodecki.homework.homework8.homework8_1;


    import org.junit.Assert;
    import org.junit.Before;
    import org.junit.Test;

    public class CustomArrayListTest {
        private static final Integer NULL = 0;
        private static final Integer ONE = 1;
        private static final Integer TWO = 2;
        private static final Integer THREE = 3;
        private static final Integer FOUR = 4;
        private static final Integer FIVE = 5;

        private CustomArrayList<Integer> list;

        @Before
        public void initiate() {
            list = new CustomArrayList<>();
        }

        @Test
        public void addIsCorrect() {
            list.add(5);
            Integer actual = list.size();
            Assert.assertEquals(ONE, actual);
        }

        @Test
        public void sizeIsCorrect() {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            Integer actual = list.size();
            Assert.assertEquals(FOUR, actual);
        }


        @Test
        public void getIsCorrect() {
            list.add(5);
            Integer actual = list.get(0);
            Assert.assertEquals(FIVE, actual);
        }

        @Test
        public void removeIsCorrectWithShiftIndexes() {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.remove(0);
            Assert.assertEquals(TWO, list.get(0));
            Assert.assertEquals(THREE, list.get(1));
            Assert.assertEquals(FOUR, list.get(2));
        }

        @Test
        public void clearIsCorrect() {
            list.add(3);
            list.add(2);
            list.clear();
            Integer actual = list.size();
            Assert.assertEquals(NULL, actual);
        }

        @Test(expected = IndexOutOfBoundsCustomException.class)
        public void addIsIncorrect() throws IndexOutOfBoundsCustomException {
            list.add(8);
            list.add(4);
            list.add(3);
            list.add(7);
            list.add(8);
            list.add(9);
        }


        @Test
        public void clearIsIncorrect() {
            list.add(5);
            list.clear();
            Integer actual = list.get(0);
            Assert.assertEquals(null, actual);
        }
    }