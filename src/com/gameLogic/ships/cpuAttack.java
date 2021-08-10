package com.gameLogic.ships;

import com.gameLogic.DrawGameOwn;
import com.gameLogic.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class cpuAttack extends JFrame {
    /*public com.gameLogic.Player src = new com.gameLogic.Player(null, null, null, null, null, 0, 0, 0, 0, false, 0, null);*/
    /*public com.gameLogic.Player tgt = new com.gameLogic.Player(null, null, null, null, null, 0, 0, 0, 0, false, 0, null);*/

    public int i, j, mode;

    public cpuAttack(Player target, Player source, long startTime) {
        Attack(source, target, startTime);
    }

    public void Attack(Player src, Player tgt, long time) {
        Random rand = new Random();
        int up = 10;
        Random rand2 = new Random();
        int up2 = 10;

        boolean proc = false;
        while (!proc) {
            int x = rand.nextInt(up);
            int y = rand2.nextInt(up2);
            String comp = x + "+" + y;
            if (src.attackHist == null) {
                src.attackHist = new ArrayList<>();
            }
            if ((!src.attackHist.contains(comp))) {
                proc = true;
                i = x;
                j = y;
            }
        }
        proc = false;
        while (!proc) {
            int x = rand.nextInt(4);
            switch (x) {
                case 1:
                    if ((!src.cooldown) && (src.porta.getTAM() > 0)) {
                        mode = 1;
                        proc = true;
                    }
                    break;
                case 2:
                    if (src.sub.getTAM() > 0) {
                        mode = 2;
                        proc = true;
                    }
                    break;
                case 3:
                    String teste1 = i + "+" + (j + 1);
                    if ((src.escolta.getTAM() > 0) && (!src.attackHist.contains(teste1)) && ((j + 1) < 9)) {
                        mode = 3;
                        proc = true;
                    }
                    break;
            }
        }

        switch (mode) {
            case 1: {
                src.attackHist.add(i + "+" + j);
                if ((i == tgt.caça.getCoordX()[0])) {
                    if ((j == tgt.caça.getCoordY()[0])) {
                        tgt.caça.getCoordRem()[0] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;
                        src.cooldown = true;

                    } else if ((j == tgt.caça.getCoordY()[1])) {
                        tgt.caça.getCoordRem()[1] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;
                        src.cooldown = true;

                    }
                } else if ((i == tgt.sub.getCoordX()[0])) {
                    if ((j == tgt.sub.getCoordY()[0])) {
                        tgt.sub.getCoordRem()[0] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;
                        src.cooldown = true;

                    } else if ((j == tgt.sub.getCoordY()[1])) {
                        tgt.sub.getCoordRem()[1] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;
                        src.cooldown = true;

                    }
                } else if ((i == tgt.escolta.getCoordX()[0])) {
                    if ((j == tgt.escolta.getCoordY()[0])) {
                        tgt.escolta.getCoordRem()[0] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;

                        src.cooldown = true;
                    } else if ((j == tgt.escolta.getCoordY()[1])) {
                        tgt.escolta.getCoordRem()[1] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;

                        src.cooldown = true;
                    } else if ((j == tgt.escolta.getCoordY()[2])) {
                        tgt.escolta.getCoordRem()[2] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;

                        src.cooldown = true;

                    }
                } else if ((i == tgt.porta.getCoordX()[0])) {
                    if ((j == tgt.porta.getCoordY()[0])) {
                        tgt.porta.getCoordRem()[0] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;

                        src.cooldown = true;

                    } else if ((j == tgt.porta.getCoordY()[1])) {
                        tgt.porta.getCoordRem()[1] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;

                        src.cooldown = true;

                    } else if ((j == tgt.porta.getCoordY()[2])) {
                        tgt.porta.getCoordRem()[2] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = true;
                    } else if ((j == tgt.porta.getCoordY()[3])) {
                        tgt.porta.getCoordRem()[3] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;

                        src.cooldown = true;

                    }
                }
            }
            case 2: {
                src.attackHist.add(i + "+" + j);
                if ((i == tgt.caça.getCoordX()[0])) {
                    if ((j == tgt.caça.getCoordY()[0])) {
                        tgt.caça.getCoordRem()[0] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;
                        src.cooldown = false;

                    } else if ((j == tgt.caça.getCoordY()[1])) {
                        tgt.caça.getCoordRem()[1] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;
                        src.cooldown = false;

                    }
                } else if ((i == tgt.sub.getCoordX()[0])) {
                    if ((j == tgt.sub.getCoordY()[0])) {
                        tgt.sub.getCoordRem()[0] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;
                        src.cooldown = false;

                    } else if ((j == tgt.sub.getCoordY()[1])) {
                        tgt.sub.getCoordRem()[1] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;
                        src.cooldown = false;

                    }
                } else if ((i == tgt.escolta.getCoordX()[0])) {
                    if ((j == tgt.escolta.getCoordY()[0])) {
                        tgt.escolta.getCoordRem()[0] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;

                        src.cooldown = false;
                    } else if ((j == tgt.escolta.getCoordY()[1])) {
                        tgt.escolta.getCoordRem()[1] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;

                        src.cooldown = false;
                    } else if ((j == tgt.escolta.getCoordY()[2])) {
                        tgt.escolta.getCoordRem()[2] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;

                        src.cooldown = false;

                    }
                } else if ((i == tgt.porta.getCoordX()[0])) {
                    if ((j == tgt.porta.getCoordY()[0])) {
                        tgt.porta.getCoordRem()[0] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;

                        src.cooldown = false;

                    } else if ((j == tgt.porta.getCoordY()[1])) {
                        tgt.porta.getCoordRem()[1] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;

                        src.cooldown = false;

                    } else if ((j == tgt.porta.getCoordY()[2])) {
                        tgt.porta.getCoordRem()[2] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;
                    } else if ((j == tgt.porta.getCoordY()[3])) {
                        tgt.porta.getCoordRem()[3] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;

                        src.cooldown = false;

                    }
                }
                src.cooldown = false;
            }
            case 3: {
                src.attackHist.add(i + "+" + j);
                if ((i == tgt.caça.getCoordX()[0])) {
                    if ((j == tgt.caça.getCoordY()[0])) {
                        tgt.caça.getCoordRem()[0] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;
                        src.cooldown = false;

                    } else if ((j == tgt.caça.getCoordY()[1])) {
                        tgt.caça.getCoordRem()[1] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    }
                } else if ((i == tgt.sub.getCoordX()[0])) {
                    if ((j == tgt.sub.getCoordY()[0])) {
                        tgt.sub.getCoordRem()[0] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    } else if ((j == tgt.sub.getCoordY()[1])) {
                        tgt.sub.getCoordRem()[1] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    }
                } else if ((i == tgt.escolta.getCoordX()[0])) {
                    if ((j == tgt.escolta.getCoordY()[0])) {
                        tgt.escolta.getCoordRem()[0] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    } else if ((j == tgt.escolta.getCoordY()[1])) {
                        tgt.escolta.getCoordRem()[1] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    } else if ((j == tgt.escolta.getCoordY()[2])) {
                        tgt.escolta.getCoordRem()[2] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    }
                } else if ((i == tgt.porta.getCoordX()[0])) {
                    if ((j == tgt.porta.getCoordY()[0])) {
                        tgt.porta.getCoordRem()[0] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    } else if ((j == tgt.porta.getCoordY()[1])) {
                        tgt.porta.getCoordRem()[1] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    } else if ((j == tgt.porta.getCoordY()[2])) {
                        tgt.porta.getCoordRem()[2] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;
                    } else if ((j == tgt.porta.getCoordY()[3])) {
                        tgt.porta.getCoordRem()[3] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;
                    }
                }
                if ((i == tgt.caça.getCoordX()[0])) {
                    if ((j + 1 == tgt.caça.getCoordY()[0])) {
                        tgt.caça.getCoordRem()[0] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;
                        src.cooldown = false;

                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.caça.getCoordY()[1])) {
                        tgt.caça.getCoordRem()[1] = j + 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;
                        src.cooldown = false;

                        src.attackHist.add(i + "+" + (j + 1));
                    }
                } else if ((i == tgt.sub.getCoordX()[0])) {
                    if ((j + 1 == tgt.sub.getCoordY()[0])) {
                        tgt.sub.getCoordRem()[0] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.sub.getCoordY()[1])) {
                        tgt.sub.getCoordRem()[1] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    }
                } else if ((i == tgt.escolta.getCoordX()[0])) {
                    if ((j + 1 == tgt.escolta.getCoordY()[0])) {
                        tgt.escolta.getCoordRem()[0] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.escolta.getCoordY()[1])) {
                        tgt.escolta.getCoordRem()[1] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.escolta.getCoordY()[2])) {
                        tgt.escolta.getCoordRem()[2] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    }
                } else if ((i == tgt.porta.getCoordX()[0])) {
                    if ((j + 1 == tgt.porta.getCoordY()[0])) {
                        tgt.porta.getCoordRem()[0] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.porta.getCoordY()[1])) {
                        tgt.porta.getCoordRem()[1] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.porta.getCoordY()[2])) {
                        tgt.porta.getCoordRem()[2] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.porta.getCoordY()[3])) {
                        tgt.porta.getCoordRem()[3] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;
                        src.attackHist.add(i + "+" + (j + 1));
                    }
                }
                src.cooldown = false;
            }
            case 4: {
                if ((i == tgt.caça.getCoordX()[0])) {
                    if ((j + 1 == tgt.caça.getCoordY()[0])) {
                        tgt.caça.getCoordRem()[0] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.caça.getCoordY()[1])) {
                        tgt.caça.getCoordRem()[1] = j + 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    }
                } else if ((i == tgt.sub.getCoordX()[0])) {
                    if ((j + 1 == tgt.sub.getCoordY()[0])) {
                        tgt.sub.getCoordRem()[0] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.sub.getCoordY()[1])) {
                        tgt.sub.getCoordRem()[1] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    }
                } else if ((i == tgt.escolta.getCoordX()[0])) {
                    if ((j + 1 == tgt.escolta.getCoordY()[0])) {
                        tgt.escolta.getCoordRem()[0] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.escolta.getCoordY()[1])) {
                        tgt.escolta.getCoordRem()[1] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.escolta.getCoordY()[2])) {
                        tgt.escolta.getCoordRem()[2] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    }
                } else if ((i == tgt.porta.getCoordX()[0])) {
                    if ((j + 1 == tgt.porta.getCoordY()[0])) {
                        tgt.porta.getCoordRem()[0] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.porta.getCoordY()[1])) {
                        tgt.porta.getCoordRem()[1] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.porta.getCoordY()[2])) {
                        tgt.porta.getCoordRem()[2] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    } else if ((j + 1 == tgt.porta.getCoordY()[3])) {
                        tgt.porta.getCoordRem()[3] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j + 1));
                    }
                }
                if ((i == tgt.caça.getCoordX()[0])) {
                    if ((j - 1 == tgt.caça.getCoordY()[0])) {
                        tgt.caça.getCoordRem()[0] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j - 1));
                    } else if ((j - 1 == tgt.caça.getCoordY()[1])) {
                        tgt.caça.getCoordRem()[1] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j - 1));
                    }
                } else if ((i == tgt.sub.getCoordX()[0])) {
                    if ((j - 1 == tgt.sub.getCoordY()[0])) {
                        tgt.sub.getCoordRem()[0] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j - 1));
                    } else if ((j - 1 == tgt.sub.getCoordY()[1])) {
                        tgt.sub.getCoordRem()[1] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j - 1));
                    }
                } else if ((i == tgt.escolta.getCoordX()[0])) {
                    if ((j - 1 == tgt.escolta.getCoordY()[0])) {
                        tgt.escolta.getCoordRem()[0] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j - 1));
                    } else if ((j - 1 == tgt.escolta.getCoordY()[1])) {
                        tgt.escolta.getCoordRem()[1] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j - 1));
                    } else if ((j - 1 == tgt.escolta.getCoordY()[2])) {
                        tgt.escolta.getCoordRem()[2] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j - 1));
                    }
                } else if ((i == tgt.porta.getCoordX()[0])) {
                    if ((j - 1 == tgt.porta.getCoordY()[0])) {
                        tgt.porta.getCoordRem()[0] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j - 1));
                    } else if ((j - 1 == tgt.porta.getCoordY()[1])) {
                        tgt.porta.getCoordRem()[1] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j - 1));
                    } else if ((j - 1 == tgt.porta.getCoordY()[2])) {
                        tgt.porta.getCoordRem()[2] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j - 1));
                    } else if ((j - 1 == tgt.porta.getCoordY()[3])) {
                        tgt.porta.getCoordRem()[3] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + "+" + (j - 1));
                    }
                }
                if ((i + 1 == tgt.caça.getCoordX()[0])) {
                    if ((j == tgt.caça.getCoordY()[0])) {
                        tgt.caça.getCoordRem()[0] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + 1 + "+" + j);
                    } else if ((j == tgt.caça.getCoordY()[1])) {
                        tgt.caça.getCoordRem()[1] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + 1 + "+" + j);
                    }
                } else if ((i + 1 == tgt.sub.getCoordX()[0])) {
                    if ((j == tgt.sub.getCoordY()[0])) {
                        tgt.sub.getCoordRem()[0] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + 1 + "+" + j);
                    } else if ((j == tgt.sub.getCoordY()[1])) {
                        tgt.sub.getCoordRem()[1] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + 1 + "+" + j);
                    }
                } else if ((i + 1 == tgt.escolta.getCoordX()[0])) {
                    if ((j == tgt.escolta.getCoordY()[0])) {
                        tgt.escolta.getCoordRem()[0] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + 1 + "+" + j);
                    } else if ((j == tgt.escolta.getCoordY()[1])) {
                        tgt.escolta.getCoordRem()[1] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + 1 + "+" + j);
                    } else if ((j == tgt.escolta.getCoordY()[2])) {
                        tgt.escolta.getCoordRem()[2] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + 1 + "+" + j);
                    }
                } else if ((i + 1 == tgt.porta.getCoordX()[0])) {
                    if ((j == tgt.porta.getCoordY()[0])) {
                        tgt.porta.getCoordRem()[0] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + 1 + "+" + j);
                    } else if ((j == tgt.porta.getCoordY()[1])) {
                        tgt.porta.getCoordRem()[1] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + 1 + "+" + j);
                    } else if ((j == tgt.porta.getCoordY()[2])) {
                        tgt.porta.getCoordRem()[2] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + 1 + "+" + j);
                    } else if ((j == tgt.porta.getCoordY()[3])) {
                        tgt.porta.getCoordRem()[3] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i + 1 + "+" + j);
                    }
                }
                if ((i - 1 == tgt.caça.getCoordX()[0])) {
                    if ((j == tgt.caça.getCoordY()[0])) {
                        tgt.caça.getCoordRem()[0] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i - 1 + "+" + j);
                    } else if ((j == tgt.caça.getCoordY()[1])) {
                        tgt.caça.getCoordRem()[1] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i - 1 + "+" + j);
                    }
                } else if ((i - 1 == tgt.sub.getCoordX()[0])) {
                    if ((j == tgt.sub.getCoordY()[0])) {
                        tgt.sub.getCoordRem()[0] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i - 1 + "+" + j);
                    } else if ((j == tgt.sub.getCoordY()[1])) {
                        tgt.sub.getCoordRem()[1] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i - 1 + "+" + j);
                    }
                } else if ((i - 1 == tgt.escolta.getCoordX()[0])) {
                    if ((j == tgt.escolta.getCoordY()[0])) {
                        tgt.escolta.getCoordRem()[0] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i - 1 + "+" + j);
                    } else if ((j == tgt.escolta.getCoordY()[1])) {
                        tgt.escolta.getCoordRem()[1] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i - 1 + "+" + j);
                    } else if ((j == tgt.escolta.getCoordY()[2])) {
                        tgt.escolta.getCoordRem()[2] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i - 1 + "+" + j);
                    }
                } else if ((i - 1 == tgt.porta.getCoordX()[0])) {
                    if ((j == tgt.porta.getCoordY()[0])) {
                        tgt.porta.getCoordRem()[0] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i - 1 + "+" + j);
                    } else if ((j == tgt.porta.getCoordY()[1])) {
                        tgt.porta.getCoordRem()[1] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i - 1 + "+" + j);
                    } else if ((j == tgt.porta.getCoordY()[2])) {
                        tgt.porta.getCoordRem()[2] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i - 1 + "+" + j);
                    } else if ((j == tgt.porta.getCoordY()[3])) {
                        tgt.porta.getCoordRem()[3] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.attackHist.add(i - 1 + "+" + j);
                    }
                }
                if ((i == tgt.caça.getCoordX()[0])) {
                    if ((j == tgt.caça.getCoordY()[0])) {
                        tgt.caça.getCoordRem()[0] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    } else if ((j == tgt.caça.getCoordY()[1])) {
                        tgt.caça.getCoordRem()[1] = 1;
                        tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    }
                } else if ((i == tgt.sub.getCoordX()[0])) {
                    if ((j == tgt.sub.getCoordY()[0])) {
                        tgt.sub.getCoordRem()[0] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    } else if ((j == tgt.sub.getCoordY()[1])) {
                        tgt.sub.getCoordRem()[1] = 1;
                        tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    }
                } else if ((i == tgt.escolta.getCoordX()[0])) {
                    if ((j == tgt.escolta.getCoordY()[0])) {
                        tgt.escolta.getCoordRem()[0] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    } else if ((j == tgt.escolta.getCoordY()[1])) {
                        tgt.escolta.getCoordRem()[1] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    } else if ((j == tgt.escolta.getCoordY()[2])) {
                        tgt.escolta.getCoordRem()[2] = 1;
                        tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    }
                } else if ((i == tgt.porta.getCoordX()[0])) {
                    if ((j == tgt.porta.getCoordY()[0])) {
                        tgt.porta.getCoordRem()[0] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    } else if ((j == tgt.porta.getCoordY()[1])) {
                        tgt.porta.getCoordRem()[1] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    } else if ((j == tgt.porta.getCoordY()[2])) {
                        tgt.porta.getCoordRem()[2] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    } else if ((j == tgt.porta.getCoordY()[3])) {
                        tgt.porta.getCoordRem()[3] = 1;
                        tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                        src.Score = src.Score + 1;


                        src.cooldown = false;

                    }
                }
                src.cooldown = false;
            }
        }
        DrawGameOwn next = new DrawGameOwn(tgt, src, time);
        //com.gameLogic.DrawGameAttack attack = new com.gameLogic.DrawGameAttack(src, tgt, time);
        next.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();
    }
}
