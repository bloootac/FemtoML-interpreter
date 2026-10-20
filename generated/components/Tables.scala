
package femtoml
object Tables {
val goto: Int => Int => Int = {
  case 0 => { case 30 => 9;  case 31 => 10;  case 32 => 11;  case 33 => 12;  case 37 => 13;  }
  case 4 => { case 31 => 17;  case 32 => 11;  case 33 => 12;  }
  case 7 => { case 37 => 22;  }
  case 11 => { case 33 => 26;  }
  case 14 => { case 31 => 30;  case 32 => 11;  case 33 => 12;  }
  case 15 => { case 35 => 37;  case 36 => 38;  }
  case 20 => { case 33 => 42;  case 34 => 43;  case 38 => 44;  case 39 => 45;  }
  case 25 => { case 30 => 48;  case 31 => 10;  case 32 => 11;  case 33 => 12;  case 37 => 13;  }
  case 27 => { case 37 => 49;  }
  case 28 => { case 30 => 50;  case 31 => 10;  case 32 => 11;  case 33 => 12;  case 37 => 13;  }
  case 29 => { case 37 => 51;  }
  case 32 => { case 35 => 52;  case 36 => 38;  }
  case 33 => { case 42 => 54;  case 43 => 55;  }
  case 41 => { case 31 => 59;  case 32 => 11;  case 33 => 12;  }
  case 46 => { case 31 => 63;  case 32 => 11;  case 33 => 12;  }
  case 47 => { case 31 => 64;  case 32 => 11;  case 33 => 12;  }
  case 56 => { case 36 => 68;  case 44 => 69;  case 45 => 70;  }
  case 57 => { case 36 => 71;  }
  case 58 => { case 31 => 72;  case 32 => 11;  case 33 => 12;  case 40 => 73;  case 41 => 74;  }
  case 60 => { case 31 => 75;  case 32 => 11;  case 33 => 12;  }
  case 61 => { case 33 => 42;  case 34 => 76;  }
  case 67 => { case 35 => 78;  case 36 => 38;  }
  case 79 => { case 36 => 83;  }
  case 81 => { case 31 => 84;  case 32 => 11;  case 33 => 12;  }
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
  case 20 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case _ => REDUCE(39,31,0);  }
  case 21 => { case 17 => SHIFT(14);  case 18 => SHIFT(15);  case _ => ERROR;  }
  case 22 => { case 20 => SHIFT(46);  case 21 => SHIFT(27);  case 27 => SHIFT(29);  case _ => ERROR;  }
  case 23 => { case 17 => SHIFT(47);  case _ => ERROR;  }
  case 24 => { case _ => ACCEPT;  }
  case 25 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(3);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case 22 => SHIFT(8);  case _ => REDUCE(30,1,0);  }
  case 26 => { case _ => REDUCE(32,8,2);  }
  case 27 => { case 5 => SHIFT(21);  case 22 => SHIFT(8);  case _ => ERROR;  }
  case 28 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(3);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case 22 => SHIFT(8);  case _ => REDUCE(30,1,0);  }
  case 29 => { case 5 => SHIFT(21);  case 22 => SHIFT(8);  case _ => ERROR;  }
  case 30 => { case _ => REDUCE(37,24,3);  }
  case 31 => { case _ => REDUCE(36,20,1);  }
  case 32 => { case 5 => SHIFT(31);  case 6 => SHIFT(32);  case 16 => SHIFT(33);  case 23 => SHIFT(34);  case 24 => SHIFT(35);  case 25 => SHIFT(36);  case _ => ERROR;  }
  case 33 => { case 5 => SHIFT(53);  case _ => REDUCE(43,39,0);  }
  case 34 => { case _ => REDUCE(36,18,1);  }
  case 35 => { case _ => REDUCE(36,19,1);  }
  case 36 => { case 8 => SHIFT(56);  case _ => ERROR;  }
  case 37 => { case _ => REDUCE(37,28,3);  }
  case 38 => { case 28 => SHIFT(57);  case _ => REDUCE(35,16,1);  }
  case 39 => { case _ => REDUCE(33,14,3);  }
  case 40 => { case 8 => SHIFT(58);  case _ => ERROR;  }
  case 41 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 42 => { case 28 => SHIFT(60);  case _ => ERROR;  }
  case 43 => { case _ => REDUCE(38,29,1);  }
  case 44 => { case 15 => SHIFT(61);  case _ => REDUCE(39,32,1);  }
  case 45 => { case 7 => SHIFT(62);  case _ => ERROR;  }
  case 46 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 47 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 48 => { case _ => REDUCE(30,2,3);  }
  case 49 => { case _ => REDUCE(37,25,3);  }
  case 50 => { case _ => REDUCE(30,3,3);  }
  case 51 => { case _ => REDUCE(37,26,3);  }
  case 52 => { case 7 => SHIFT(65);  case _ => ERROR;  }
  case 53 => { case _ => REDUCE(42,37,1);  }
  case 54 => { case 14 => SHIFT(66);  case _ => REDUCE(43,40,1);  }
  case 55 => { case 13 => SHIFT(67);  case _ => ERROR;  }
  case 56 => { case 5 => SHIFT(31);  case 6 => SHIFT(32);  case 23 => SHIFT(34);  case 24 => SHIFT(35);  case 25 => SHIFT(36);  case _ => REDUCE(45,43,0);  }
  case 57 => { case 5 => SHIFT(31);  case 6 => SHIFT(32);  case 23 => SHIFT(34);  case 24 => SHIFT(35);  case 25 => SHIFT(36);  case _ => ERROR;  }
  case 58 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => REDUCE(41,35,0);  }
  case 59 => { case _ => REDUCE(31,5,4);  }
  case 60 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 61 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case _ => ERROR;  }
  case 62 => { case _ => REDUCE(31,6,4);  }
  case 63 => { case _ => REDUCE(31,7,4);  }
  case 64 => { case _ => REDUCE(37,27,4);  }
  case 65 => { case _ => REDUCE(36,23,3);  }
  case 66 => { case 5 => SHIFT(77);  case _ => ERROR;  }
  case 67 => { case 5 => SHIFT(31);  case 6 => SHIFT(32);  case 16 => SHIFT(33);  case 23 => SHIFT(34);  case 24 => SHIFT(35);  case 25 => SHIFT(36);  case _ => ERROR;  }
  case 68 => { case 28 => SHIFT(57);  case _ => REDUCE(44,41,1);  }
  case 69 => { case 14 => SHIFT(79);  case _ => REDUCE(45,44,1);  }
  case 70 => { case 9 => SHIFT(80);  case _ => ERROR;  }
  case 71 => { case 28 => SHIFT(57);  case _ => REDUCE(36,22,3);  }
  case 72 => { case _ => REDUCE(40,33,1);  }
  case 73 => { case 14 => SHIFT(81);  case _ => REDUCE(41,36,1);  }
  case 74 => { case 9 => SHIFT(82);  case _ => ERROR;  }
  case 75 => { case _ => REDUCE(34,15,3);  }
  case 76 => { case _ => REDUCE(38,30,3);  }
  case 77 => { case _ => REDUCE(42,38,3);  }
  case 78 => { case _ => REDUCE(35,17,4);  }
  case 79 => { case 5 => SHIFT(31);  case 6 => SHIFT(32);  case 23 => SHIFT(34);  case 24 => SHIFT(35);  case 25 => SHIFT(36);  case _ => ERROR;  }
  case 80 => { case _ => REDUCE(36,21,4);  }
  case 81 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(16);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 82 => { case 11 => SHIFT(85);  case _ => ERROR;  }
  case 83 => { case 28 => SHIFT(57);  case _ => REDUCE(44,42,3);  }
  case 84 => { case _ => REDUCE(40,34,3);  }
  case 85 => { case _ => REDUCE(33,13,7);  }
  case _ => { case _ => ERROR }
  }
}
