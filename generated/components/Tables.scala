
package femtoml
object Tables {
val goto: Int => Int => Int = {
  case 0 => { case 30 => 9;  case 31 => 10;  case 32 => 11;  case 33 => 12;  case 38 => 13;  }
  case 4 => { case 31 => 17;  case 32 => 11;  case 33 => 12;  }
  case 7 => { case 38 => 22;  }
  case 11 => { case 33 => 26;  }
  case 14 => { case 31 => 30;  case 32 => 11;  case 33 => 12;  }
  case 15 => { case 36 => 37;  case 37 => 38;  }
  case 20 => { case 34 => 47;  case 35 => 48;  case 39 => 49;  case 40 => 50;  }
  case 25 => { case 30 => 53;  case 31 => 10;  case 32 => 11;  case 33 => 12;  case 38 => 13;  }
  case 27 => { case 38 => 54;  }
  case 28 => { case 30 => 55;  case 31 => 10;  case 32 => 11;  case 33 => 12;  case 38 => 13;  }
  case 29 => { case 38 => 56;  }
  case 32 => { case 36 => 57;  case 37 => 38;  }
  case 33 => { case 45 => 59;  case 46 => 60;  }
  case 41 => { case 31 => 64;  case 32 => 11;  case 33 => 12;  }
  case 45 => { case 34 => 65;  }
  case 51 => { case 31 => 70;  case 32 => 11;  case 33 => 12;  }
  case 52 => { case 31 => 71;  case 32 => 11;  case 33 => 12;  }
  case 61 => { case 37 => 75;  case 47 => 76;  case 48 => 77;  }
  case 62 => { case 37 => 78;  }
  case 63 => { case 31 => 79;  case 32 => 11;  case 33 => 12;  case 41 => 80;  case 42 => 81;  }
  case 67 => { case 31 => 84;  case 32 => 11;  case 33 => 12;  }
  case 68 => { case 34 => 47;  case 35 => 85;  }
  case 74 => { case 36 => 87;  case 37 => 38;  }
  case 88 => { case 37 => 93;  }
  case 90 => { case 31 => 94;  case 32 => 11;  case 33 => 12;  }
  case 92 => { case 34 => 96;  case 43 => 97;  case 44 => 98;  }
  case 99 => { case 34 => 101;  }
  case state => { case symbol => throw org.sufrin.scalalr.ErroneousGoto(state, symbol)}
  }

import org.sufrin.scalalr.Action._
val action: Int => Int => Action = {
  case 0 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(3);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case 22 => SHIFT(8);  case _ => REDUCE(30,1,0);  }
  case 1 => { case _ => REDUCE(33,10,1);  }
  case 2 => { case _ => REDUCE(33,11,1);  }
  case 3 => { case 17 => SHIFT(14);  case 18 => SHIFT(15);  case _ => REDUCE(33,12,1);  }
  case 4 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 5 => { case 5 => SHIFT(18);  case _ => ERROR;  }
  case 6 => { case 5 => SHIFT(19);  case 6 => SHIFT(20);  case _ => ERROR;  }
  case 7 => { case 5 => SHIFT(21);  case 22 => SHIFT(8);  case _ => ERROR;  }
  case 8 => { case 5 => SHIFT(23);  case _ => ERROR;  }
  case 9 => { case 0 => SHIFT(24);  case _ => ERROR;  }
  case 10 => { case 26 => SHIFT(25);  case _ => ERROR;  }
  case 11 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case _ => REDUCE(31,4,1);  }
  case 12 => { case _ => REDUCE(32,9,1);  }
  case 13 => { case 21 => SHIFT(27);  case 26 => SHIFT(28);  case 27 => SHIFT(29);  case _ => ERROR;  }
  case 14 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 15 => { case 5 => SHIFT(31);  case 6 => SHIFT(32);  case 16 => SHIFT(33);  case 23 => SHIFT(34);  case 24 => SHIFT(35);  case 25 => SHIFT(36);  case _ => ERROR;  }
  case 16 => { case _ => REDUCE(33,12,1);  }
  case 17 => { case 7 => SHIFT(39);  case _ => ERROR;  }
  case 18 => { case 14 => SHIFT(40);  case _ => ERROR;  }
  case 19 => { case 13 => SHIFT(41);  case _ => ERROR;  }
  case 20 => { case 3 => SHIFT(42);  case 4 => SHIFT(43);  case 5 => SHIFT(44);  case 6 => SHIFT(45);  case 10 => SHIFT(46);  case _ => REDUCE(40,36,0);  }
  case 21 => { case 17 => SHIFT(14);  case 18 => SHIFT(15);  case _ => ERROR;  }
  case 22 => { case 20 => SHIFT(51);  case 21 => SHIFT(27);  case 27 => SHIFT(29);  case _ => ERROR;  }
  case 23 => { case 17 => SHIFT(52);  case _ => ERROR;  }
  case 24 => { case _ => ACCEPT;  }
  case 25 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(3);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case 22 => SHIFT(8);  case _ => REDUCE(30,1,0);  }
  case 26 => { case _ => REDUCE(32,8,2);  }
  case 27 => { case 5 => SHIFT(21);  case 22 => SHIFT(8);  case _ => ERROR;  }
  case 28 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(3);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case 22 => SHIFT(8);  case _ => REDUCE(30,1,0);  }
  case 29 => { case 5 => SHIFT(21);  case 22 => SHIFT(8);  case _ => ERROR;  }
  case 30 => { case _ => REDUCE(38,29,3);  }
  case 31 => { case _ => REDUCE(37,25,1);  }
  case 32 => { case 5 => SHIFT(31);  case 6 => SHIFT(32);  case 16 => SHIFT(33);  case 23 => SHIFT(34);  case 24 => SHIFT(35);  case 25 => SHIFT(36);  case _ => ERROR;  }
  case 33 => { case 5 => SHIFT(58);  case _ => REDUCE(46,48,0);  }
  case 34 => { case _ => REDUCE(37,23,1);  }
  case 35 => { case _ => REDUCE(37,24,1);  }
  case 36 => { case 8 => SHIFT(61);  case _ => ERROR;  }
  case 37 => { case _ => REDUCE(38,33,3);  }
  case 38 => { case 28 => SHIFT(62);  case _ => REDUCE(36,21,1);  }
  case 39 => { case _ => REDUCE(33,14,3);  }
  case 40 => { case 8 => SHIFT(63);  case _ => ERROR;  }
  case 41 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 42 => { case _ => REDUCE(34,15,1);  }
  case 43 => { case _ => REDUCE(34,16,1);  }
  case 44 => { case _ => REDUCE(34,17,1);  }
  case 45 => { case 3 => SHIFT(42);  case 4 => SHIFT(43);  case 5 => SHIFT(44);  case 6 => SHIFT(45);  case 10 => SHIFT(46);  case _ => ERROR;  }
  case 46 => { case 5 => SHIFT(66);  case _ => ERROR;  }
  case 47 => { case 28 => SHIFT(67);  case _ => ERROR;  }
  case 48 => { case _ => REDUCE(39,34,1);  }
  case 49 => { case 15 => SHIFT(68);  case _ => REDUCE(40,37,1);  }
  case 50 => { case 7 => SHIFT(69);  case _ => ERROR;  }
  case 51 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 52 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 53 => { case _ => REDUCE(30,2,3);  }
  case 54 => { case _ => REDUCE(38,30,3);  }
  case 55 => { case _ => REDUCE(30,3,3);  }
  case 56 => { case _ => REDUCE(38,31,3);  }
  case 57 => { case 7 => SHIFT(72);  case _ => ERROR;  }
  case 58 => { case _ => REDUCE(45,46,1);  }
  case 59 => { case 14 => SHIFT(73);  case _ => REDUCE(46,49,1);  }
  case 60 => { case 13 => SHIFT(74);  case _ => ERROR;  }
  case 61 => { case 5 => SHIFT(31);  case 6 => SHIFT(32);  case 23 => SHIFT(34);  case 24 => SHIFT(35);  case 25 => SHIFT(36);  case _ => REDUCE(48,52,0);  }
  case 62 => { case 5 => SHIFT(31);  case 6 => SHIFT(32);  case 23 => SHIFT(34);  case 24 => SHIFT(35);  case 25 => SHIFT(36);  case _ => ERROR;  }
  case 63 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => REDUCE(42,40,0);  }
  case 64 => { case _ => REDUCE(31,5,4);  }
  case 65 => { case 7 => SHIFT(82);  case _ => ERROR;  }
  case 66 => { case 14 => SHIFT(83);  case _ => ERROR;  }
  case 67 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 68 => { case 3 => SHIFT(42);  case 4 => SHIFT(43);  case 5 => SHIFT(44);  case 6 => SHIFT(45);  case 10 => SHIFT(46);  case _ => ERROR;  }
  case 69 => { case _ => REDUCE(31,6,4);  }
  case 70 => { case _ => REDUCE(31,7,4);  }
  case 71 => { case _ => REDUCE(38,32,4);  }
  case 72 => { case _ => REDUCE(37,28,3);  }
  case 73 => { case 5 => SHIFT(86);  case _ => ERROR;  }
  case 74 => { case 5 => SHIFT(31);  case 6 => SHIFT(32);  case 16 => SHIFT(33);  case 23 => SHIFT(34);  case 24 => SHIFT(35);  case 25 => SHIFT(36);  case _ => ERROR;  }
  case 75 => { case 28 => SHIFT(62);  case _ => REDUCE(47,50,1);  }
  case 76 => { case 14 => SHIFT(88);  case _ => REDUCE(48,53,1);  }
  case 77 => { case 9 => SHIFT(89);  case _ => ERROR;  }
  case 78 => { case 28 => SHIFT(62);  case _ => REDUCE(37,27,3);  }
  case 79 => { case _ => REDUCE(41,38,1);  }
  case 80 => { case 14 => SHIFT(90);  case _ => REDUCE(42,41,1);  }
  case 81 => { case 9 => SHIFT(91);  case _ => ERROR;  }
  case 82 => { case _ => REDUCE(34,19,3);  }
  case 83 => { case 8 => SHIFT(92);  case _ => ERROR;  }
  case 84 => { case _ => REDUCE(35,20,3);  }
  case 85 => { case _ => REDUCE(39,35,3);  }
  case 86 => { case _ => REDUCE(45,47,3);  }
  case 87 => { case _ => REDUCE(36,22,4);  }
  case 88 => { case 5 => SHIFT(31);  case 6 => SHIFT(32);  case 23 => SHIFT(34);  case 24 => SHIFT(35);  case 25 => SHIFT(36);  case _ => ERROR;  }
  case 89 => { case _ => REDUCE(37,26,4);  }
  case 90 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 91 => { case 11 => SHIFT(95);  case _ => ERROR;  }
  case 92 => { case 3 => SHIFT(42);  case 4 => SHIFT(43);  case 5 => SHIFT(44);  case 6 => SHIFT(45);  case 10 => SHIFT(46);  case _ => REDUCE(44,44,0);  }
  case 93 => { case 28 => SHIFT(62);  case _ => REDUCE(47,51,3);  }
  case 94 => { case _ => REDUCE(41,39,3);  }
  case 95 => { case _ => REDUCE(33,13,7);  }
  case 96 => { case _ => REDUCE(43,42,1);  }
  case 97 => { case 14 => SHIFT(99);  case _ => REDUCE(44,45,1);  }
  case 98 => { case 9 => SHIFT(100);  case _ => ERROR;  }
  case 99 => { case 3 => SHIFT(42);  case 4 => SHIFT(43);  case 5 => SHIFT(44);  case 6 => SHIFT(45);  case 10 => SHIFT(46);  case _ => ERROR;  }
  case 100 => { case 11 => SHIFT(102);  case _ => ERROR;  }
  case 101 => { case _ => REDUCE(43,43,3);  }
  case 102 => { case _ => REDUCE(34,18,7);  }
  case _ => { case _ => ERROR }
  }
}
