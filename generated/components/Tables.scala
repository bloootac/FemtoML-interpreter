
package femtoml
object Tables {
val goto: Int => Int => Int = {
  case 0 => { case 30 => 9;  case 31 => 10;  case 35 => 11;  }
  case 4 => { case 31 => 15;  }
  case 7 => { case 35 => 20;  }
  case 12 => { case 31 => 27;  }
  case 13 => { case 33 => 34;  case 34 => 35;  }
  case 18 => { case 31 => 39;  case 32 => 40;  case 38 => 41;  case 39 => 42;  }
  case 23 => { case 30 => 45;  case 31 => 10;  case 35 => 11;  }
  case 24 => { case 35 => 46;  }
  case 25 => { case 30 => 47;  case 31 => 10;  case 35 => 11;  }
  case 26 => { case 35 => 48;  }
  case 29 => { case 33 => 49;  case 34 => 35;  }
  case 30 => { case 40 => 51;  case 41 => 52;  }
  case 38 => { case 31 => 56;  }
  case 43 => { case 31 => 60;  }
  case 44 => { case 31 => 61;  }
  case 53 => { case 34 => 65;  case 42 => 66;  case 43 => 67;  }
  case 54 => { case 34 => 68;  }
  case 55 => { case 31 => 69;  case 36 => 70;  case 37 => 71;  }
  case 57 => { case 31 => 72;  }
  case 58 => { case 31 => 39;  case 32 => 73;  }
  case 64 => { case 33 => 75;  case 34 => 35;  }
  case 76 => { case 34 => 80;  }
  case 78 => { case 31 => 81;  }
  case state => { case symbol => throw org.sufrin.scalalr.ErroneousGoto(state, symbol)}
  }

import org.sufrin.scalalr.Action._
val action: Int => Int => Action = {
  case 0 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(3);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case 22 => SHIFT(8);  case _ => REDUCE(30,1,0);  }
  case 1 => { case _ => REDUCE(31,4,1);  }
  case 2 => { case _ => REDUCE(31,5,1);  }
  case 3 => { case 17 => SHIFT(12);  case 18 => SHIFT(13);  case _ => REDUCE(31,6,1);  }
  case 4 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(14);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 5 => { case 5 => SHIFT(16);  case _ => ERROR;  }
  case 6 => { case 5 => SHIFT(17);  case 6 => SHIFT(18);  case _ => ERROR;  }
  case 7 => { case 5 => SHIFT(19);  case 22 => SHIFT(8);  case _ => ERROR;  }
  case 8 => { case 5 => SHIFT(21);  case _ => ERROR;  }
  case 9 => { case 0 => SHIFT(22);  case _ => ERROR;  }
  case 10 => { case 26 => SHIFT(23);  case _ => ERROR;  }
  case 11 => { case 21 => SHIFT(24);  case 26 => SHIFT(25);  case 27 => SHIFT(26);  case _ => ERROR;  }
  case 12 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(14);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 13 => { case 5 => SHIFT(28);  case 6 => SHIFT(29);  case 16 => SHIFT(30);  case 23 => SHIFT(31);  case 24 => SHIFT(32);  case 25 => SHIFT(33);  case _ => ERROR;  }
  case 14 => { case _ => REDUCE(31,6,1);  }
  case 15 => { case 7 => SHIFT(36);  case _ => ERROR;  }
  case 16 => { case 14 => SHIFT(37);  case _ => ERROR;  }
  case 17 => { case 13 => SHIFT(38);  case _ => ERROR;  }
  case 18 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(14);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => REDUCE(39,32,0);  }
  case 19 => { case 17 => SHIFT(12);  case 18 => SHIFT(13);  case _ => ERROR;  }
  case 20 => { case 20 => SHIFT(43);  case 21 => SHIFT(24);  case 27 => SHIFT(26);  case _ => ERROR;  }
  case 21 => { case 17 => SHIFT(44);  case _ => ERROR;  }
  case 22 => { case _ => ACCEPT;  }
  case 23 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(3);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case 22 => SHIFT(8);  case _ => REDUCE(30,1,0);  }
  case 24 => { case 5 => SHIFT(19);  case 22 => SHIFT(8);  case _ => ERROR;  }
  case 25 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(3);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case 22 => SHIFT(8);  case _ => REDUCE(30,1,0);  }
  case 26 => { case 5 => SHIFT(19);  case 22 => SHIFT(8);  case _ => ERROR;  }
  case 27 => { case _ => REDUCE(35,21,3);  }
  case 28 => { case _ => REDUCE(34,17,1);  }
  case 29 => { case 5 => SHIFT(28);  case 6 => SHIFT(29);  case 16 => SHIFT(30);  case 23 => SHIFT(31);  case 24 => SHIFT(32);  case 25 => SHIFT(33);  case _ => ERROR;  }
  case 30 => { case 5 => SHIFT(50);  case _ => REDUCE(41,36,0);  }
  case 31 => { case _ => REDUCE(34,15,1);  }
  case 32 => { case _ => REDUCE(34,16,1);  }
  case 33 => { case 8 => SHIFT(53);  case _ => ERROR;  }
  case 34 => { case _ => REDUCE(35,25,3);  }
  case 35 => { case 28 => SHIFT(54);  case _ => REDUCE(33,13,1);  }
  case 36 => { case _ => REDUCE(31,7,3);  }
  case 37 => { case 8 => SHIFT(55);  case _ => ERROR;  }
  case 38 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(14);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 39 => { case 28 => SHIFT(57);  case _ => ERROR;  }
  case 40 => { case _ => REDUCE(38,30,1);  }
  case 41 => { case 15 => SHIFT(58);  case _ => REDUCE(39,33,1);  }
  case 42 => { case 7 => SHIFT(59);  case _ => ERROR;  }
  case 43 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(14);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 44 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(14);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 45 => { case _ => REDUCE(30,2,3);  }
  case 46 => { case _ => REDUCE(35,22,3);  }
  case 47 => { case _ => REDUCE(30,3,3);  }
  case 48 => { case _ => REDUCE(35,23,3);  }
  case 49 => { case 7 => SHIFT(62);  case _ => ERROR;  }
  case 50 => { case _ => REDUCE(40,34,1);  }
  case 51 => { case 14 => SHIFT(63);  case _ => REDUCE(41,37,1);  }
  case 52 => { case 13 => SHIFT(64);  case _ => ERROR;  }
  case 53 => { case 5 => SHIFT(28);  case 6 => SHIFT(29);  case 23 => SHIFT(31);  case 24 => SHIFT(32);  case 25 => SHIFT(33);  case _ => REDUCE(43,40,0);  }
  case 54 => { case 5 => SHIFT(28);  case 6 => SHIFT(29);  case 23 => SHIFT(31);  case 24 => SHIFT(32);  case 25 => SHIFT(33);  case _ => ERROR;  }
  case 55 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(14);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => REDUCE(37,28,0);  }
  case 56 => { case _ => REDUCE(31,9,4);  }
  case 57 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(14);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 58 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(14);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 59 => { case _ => REDUCE(31,10,4);  }
  case 60 => { case _ => REDUCE(31,11,4);  }
  case 61 => { case _ => REDUCE(35,24,4);  }
  case 62 => { case _ => REDUCE(34,20,3);  }
  case 63 => { case 5 => SHIFT(74);  case _ => ERROR;  }
  case 64 => { case 5 => SHIFT(28);  case 6 => SHIFT(29);  case 16 => SHIFT(30);  case 23 => SHIFT(31);  case 24 => SHIFT(32);  case 25 => SHIFT(33);  case _ => ERROR;  }
  case 65 => { case 28 => SHIFT(54);  case _ => REDUCE(42,38,1);  }
  case 66 => { case 14 => SHIFT(76);  case _ => REDUCE(43,41,1);  }
  case 67 => { case 9 => SHIFT(77);  case _ => ERROR;  }
  case 68 => { case 28 => SHIFT(54);  case _ => REDUCE(34,19,3);  }
  case 69 => { case _ => REDUCE(36,26,1);  }
  case 70 => { case 14 => SHIFT(78);  case _ => REDUCE(37,29,1);  }
  case 71 => { case 9 => SHIFT(79);  case _ => ERROR;  }
  case 72 => { case _ => REDUCE(32,12,3);  }
  case 73 => { case _ => REDUCE(38,31,3);  }
  case 74 => { case _ => REDUCE(40,35,3);  }
  case 75 => { case _ => REDUCE(33,14,4);  }
  case 76 => { case 5 => SHIFT(28);  case 6 => SHIFT(29);  case 23 => SHIFT(31);  case 24 => SHIFT(32);  case 25 => SHIFT(33);  case _ => ERROR;  }
  case 77 => { case _ => REDUCE(34,18,4);  }
  case 78 => { case 3 => SHIFT(1);  case 4 => SHIFT(2);  case 5 => SHIFT(14);  case 6 => SHIFT(4);  case 10 => SHIFT(5);  case 12 => SHIFT(6);  case 19 => SHIFT(7);  case _ => ERROR;  }
  case 79 => { case 11 => SHIFT(82);  case _ => ERROR;  }
  case 80 => { case 28 => SHIFT(54);  case _ => REDUCE(42,39,3);  }
  case 81 => { case _ => REDUCE(36,27,3);  }
  case 82 => { case _ => REDUCE(31,8,7);  }
  case _ => { case _ => ERROR }
  }
}
