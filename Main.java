import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static char[][] createBoard(){
        char[][] board = new char[9][9];

        for(int i = 8; i >=0; i--){
            if(i == 0) {
                char temp = 'a';
                for (int j = 1; j < 9; j++) {
                    board[i][j] = temp;
                    temp++;
                }
                continue;
            }
            for (int j = 0; j < 9; j++) {
                if(j == 0)
                    board[i][j] = Character.forDigit(i,10);
                else
                    board[i][j] = '0';
            }
        }

        board[0][0] = '/';

        board[8][5] = '♔';
        board[8][4] = '♕';
        board[8][1] = board[8][8] = '♖';
        board[8][2] = board[8][7] = '♘';
        board[8][3] = board[8][6] = '♗';

        board[1][5] = '♚';
        board[1][4] = '♛';
        board[1][1] = board[1][8] = '♜';
        board[1][2] = board[1][7] = '♞';
        board[1][3] = board[1][6] = '♝';

        for(int i = 1; i < 9; i++)
            board[7][i] = '♙';
        for(int i = 1; i < 9; i++)
            board[2][i] = '♟';

        return board;
    }
    public static void printMas (char[][] mas){
        for(int i = 8; i >=0; i--){
            for(int j = 0; j <9; j++)
                if(mas[i][j] != '0')
                    System.out.print(mas[i][j] + "\t");
                else if((i+j)%2!=0)
                    System.out.print("■\t");
                else
                    System.out.print("□\t");
            System.out.println();
        }
    }
    public static boolean attacked(char[][] board, byte[] sq, boolean whTurn){
        //sq[1] + i<9 ||sq[1]-i>0||sq[0]+i<9||sq[0]-i>0
        if(whTurn){
            for(int i = 1; (sq[1] + i<9 && sq[0]-i>0); i++){
                char temp = board[sq[1] + i][sq[0] -i];
                if(temp != '0')
                    if (temp == '♗' || temp == '♕' || (i==1 && temp=='♙'))
                        return true;
                    else
                        break;
            }
            for(int i = 1; (sq[1] + i<9 && sq[0]+i<9); i++){
                char temp = board[sq[1] + i][sq[0] +i];
                if(temp != '0')
                    if (temp == '♗' || temp == '♕' || (i==1 && temp=='♙'))
                        return true;
                    else
                        break;
            }
            for(int i = 1; (sq[1]-i>0 && sq[0]+i<9); i++){
                char temp = board[sq[1] - i][sq[0] +i];
                if(temp != '0')
                    if (temp == '♗' || temp == '♕')
                        return true;
                    else
                        break;
            }
            for(int i = 1; (sq[1]-i>0 && sq[0]-i>0); i++){
                char temp = board[sq[1] - i][sq[0] -i];
                if(temp != '0')
                    if (temp == '♗' || temp == '♕')
                        return true;
                    else
                        break;
            }
            for(int i = 1; sq[0] + i < 9; i++){
                char temp = board[sq[1]][sq[0] +i];
                if(temp != '0')
                    if (temp == '♖' || temp == '♕')
                        return true;
                    else
                        break;
            }
            for(int i = 1; sq[1] + i < 9; i++){
                char temp = board[sq[1]+i][sq[0]];
                if(temp != '0')
                    if (temp == '♖' || temp == '♕')
                        return true;
                    else
                        break;
            }
            for(int i = 1; sq[1] - i > 0; i++){
                char temp = board[sq[1]-i][sq[0]];
                if(temp != '0')
                    if (temp == '♖' || temp == '♕')
                        return true;
                    else
                        break;
            }
            for(int i = 1; sq[0] - i > 0; i++){
                char temp = board[sq[1]][sq[0]-i];
                if(temp != '0')
                    if (temp == '♖' || temp == '♕')
                        return true;
                    else
                        break;
            }
        }
        else {
            for(int i = 1; (sq[1] + i<9 && sq[0]-i>0); i++){
                char temp = board[sq[1] + i][sq[0] -i];
                if(temp != '0')
                    if (temp == '♝' || temp == '♛')
                        return true;
                    else
                        break;
            }
            for(int i = 1; (sq[1] + i<9 && sq[0]+i<9); i++){
                char temp = board[sq[1] + i][sq[0] +i];
                if(temp != '0')
                    if (temp == '♝' || temp == '♛')
                        return true;
                    else
                        break;
            }
            for(int i = 1; (sq[1]-i>0 && sq[0]+i<9); i++){
                char temp = board[sq[1] - i][sq[0] +i];
                if(temp != '0')
                    if (temp == '♝' || temp == '♛' || (i==1 && temp=='♟'))
                        return true;
                    else
                        break;
            }
            for(int i = 1; (sq[1]-i>0 && sq[0]-i>0); i++){
                char temp = board[sq[1] - i][sq[0] -i];
                if(temp != '0')
                    if (temp == '♝' || temp == '♛' || (i==1 && temp=='♟'))
                        return true;
                    else
                        break;
            }
            for(int i = 1; sq[0] + i < 9; i++){
                char temp = board[sq[1]][sq[0] +i];
                if(temp != '0')
                    if (temp == '♜' || temp == '♛')
                        return true;
                    else
                        break;
            }
            for(int i = 1; sq[1] + i < 9; i++){
                char temp = board[sq[1]+i][sq[0]];
                if(temp != '0')
                    if (temp == '♜' || temp == '♛')
                        return true;
                    else
                        break;
            }
            for(int i = 1; sq[1] - i > 0; i++){
                char temp = board[sq[1]-i][sq[0]];
                if(temp != '0')
                    if (temp == '♜' || temp == '♛')
                        return true;
                    else
                        break;
            }
            for(int i = 1; sq[0] - i > 0; i++){
                char temp = board[sq[1]][sq[0]-i];
                if(temp != '0')
                    if (temp == '♜' || temp == '♛')
                        return true;
                    else
                        break;
            }
        }


        return false;
    }
    public static boolean moveCheck(byte[] sq, byte [] sq2, char[][] board, boolean whTurn, byte[] enPas){
        char p = board[sq[1]][sq[0]];
        String whPieces = "♛♚♝♞♜♟";
        if(board[sq2[1]][sq2[0]]!= '0' && ((whTurn && whPieces.indexOf(board[sq2[1]][sq2[0]]) != -1) || (!whTurn && whPieces.indexOf(board[sq2[1]][sq2[0]]) == -1)))
            return false;

        else if(p == '♞' || p == '♘'){
            int h = Math.abs(sq[0]-sq2[0]);
            int v = Math.abs(sq[1]-sq2[1]);
            return (h == 2 || h == 1) && h + v == 3;
        }
        else if(p == '♜' || p == '♖'){
            if(sq[0] == sq2[0]){
                int t = (sq[1] > sq2[1] ? -1 : 1);
                for(int i = sq[1] +t; i != sq2[1]; i+=t)
                    if(board[i][sq[0]] != '0')
                        return false;
                return true;
            }
            else if(sq[1] == sq2[1]){
                int t = (sq[0] > sq2[0] ? -1 : 1);
                for(int i = sq[0]+ t; i != sq2[0]; i+=t)
                    if(board[sq[1]][i] != '0')
                        return false;
                return true;
            }
        }
        else if(p == '♝' || p == '♗'){
            if(Math.abs(sq[1] - sq2[1]) == Math.abs(sq[0] - sq2[0])){
                int t = (sq[1] > sq2[1] ? -1 : 1);
                int t2 = (sq[0] > sq2[0] ? -1 : 1);
                for(int i = 1; i != Math.abs(sq[1] - sq2[1]); i++)
                    if(board[sq[1] + i*t][sq[0] + i*t2] != '0')
                        return false;
                return true;
            }
        }
        else if(p == '♚' || p == '♔'){
            return Math.abs(sq[1] - sq2[1]) <= 1 && Math.abs(sq[0] - sq2[0]) <= 1;
        }
        else if(p == '♛' || p == '♕'){
            if(sq[0] == sq2[0]){
                int t = (sq[1] > sq2[1] ? -1 : 1);
                for(int i = sq[1] +t; i != sq2[1]; i+=t)
                    if(board[i][sq[0]] != '0')
                        return false;
                return true;
            }
            else if(sq[1] == sq2[1]){
                int t = (sq[0] > sq2[0] ? -1 : 1);
                for(int i = sq[0]+ t; i != sq2[0]; i+=t)
                    if(board[sq[1]][i] != '0')
                        return false;
                return true;
            }
            else if(Math.abs(sq[1] - sq2[1]) == Math.abs(sq[0] - sq2[0])){
                int t = (sq[1] > sq2[1] ? -1 : 1);
                int t2 = (sq[0] > sq2[0] ? -1 : 1);
                for(int i = 1; i != Math.abs(sq[1] - sq2[1]); i++)
                    if(board[sq[1] + i*t][sq[0] + i*t2] != '0')
                        return false;
                return true;
            }
        }
        else if(p == '♟'){
            if(sq[0] == sq2[0] && sq2[1] - sq[1] == 1 && board[sq2[1]][sq2[0]] == '0')
                return true;
            else if (sq[0] == sq2[0] && sq2[1] - sq[1] == 2 && board[sq2[1]][sq2[0]] == '0' && board[sq2[1]-1][sq2[0]] == '0' && sq[1] == 2)
                return true;
            else return Math.abs(sq[0] - sq2[0]) == 1 && sq2[1] - sq[1] == 1 && (board[sq2[1]][sq2[0]] != '0' || (sq2[1] == enPas[1] && sq2[0] == enPas[0]));
        }
        else if(p == '♙'){
            if(sq[0] == sq2[0] && sq[1] - sq2[1] == 1 && board[sq2[1]][sq2[0]] == '0')
                return true;
            else if (sq[0] == sq2[0] && sq[1] - sq2[1] == 2 && board[sq2[1]][sq2[0]] == '0' && board[sq2[1]+1][sq2[0]] == '0' && sq[1] == 7)
                return true;
            else return Math.abs(sq[0] - sq2[0]) == 1 && sq[1] - sq2[1] == 1 && (board[sq2[1]][sq2[0]] != '0' || (sq2[1] == enPas[1] && sq2[0] == enPas[0]));
        }


        return false;
    }

    public static void main(String[] args) {
        String whPieces = "♛♚♝♞♜♟";
//        String blPieces = "♕♔♗♘♖♙";

        char[][] board = createBoard();
        printMas(board);
        Scanner sc = new Scanner(System.in);
        boolean whTurn = true;
        byte[] enPas = {0,0};
        byte[] wKing = {5,1};
        byte[] bKing = {5,8};
        boolean[][] castle = {{true,true},{true,true}};
        while(true){
            String input = sc.next();
            if(input.length() == 2){
                char[] temp = input.toCharArray();
                byte[] sq = {(byte)(temp[0]-96),(byte)(temp[1]-48)};
                if(sq[0] < 1 || sq[0] > 8 || sq[1] < 1 || sq[1] > 8){
                    System.out.println("Invalid square name");
                    continue;
                }
                if(board[sq[1]][sq[0]] == '0' || (whTurn && whPieces.indexOf(board[sq[1]][sq[0]]) == -1) || (!whTurn && whPieces.indexOf(board[sq[1]][sq[0]]) != -1)){
                    System.out.println("No your pieces on that square");
                    continue;
                }

                System.out.println(board[sq[1]][sq[0]]);
                String input2 =sc.next();
                if(input2.length() != 2){
                    System.out.println("Invalid square name");
                    continue;
                }
                temp = input2.toCharArray();
                byte[] sq2 = {(byte)(temp[0]-96),(byte)(temp[1]-48)};
                if(sq2[0] < 1 || sq2[0] > 8 || sq2[1] < 1 || sq2[1] > 8){
                    System.out.println("Invalid square name");
                    continue;
                }
                if(moveCheck(sq,sq2,board,whTurn,enPas)){
                    if(board[sq[1]][sq[0]] == '♟' && sq2[1] == 8){
                        System.out.println("q or k?");
                        if(sc.next().equals("k"))
                            board[sq[1]][sq[0]] = '♞';
                        else
                            board[sq[1]][sq[0]] = '♛';
                    }
                    if(board[sq[1]][sq[0]] == '♙' && sq2[1] == 1){
                        System.out.println("q or k?");
                        if(sc.next().equals("k"))
                            board[sq[1]][sq[0]] = '♘';
                        else
                            board[sq[1]][sq[0]] = '♕';
                    }
                    char t1 = board[sq[1]][sq2[0]];
                    if((board[sq[1]][sq[0]] == '♙' || board[sq[1]][sq[0]] == '♟') && Math.abs(sq2[0]-sq[0]) == 1 && board[sq2[1]][sq2[0]] == '0')
                        board[sq[1]][sq2[0]] = '0';
                    char t2 = board[sq2[1]][sq2[0]];
                    board[sq2[1]][sq2[0]] = board[sq[1]][sq[0]];
                    board[sq[1]][sq[0]] = '0';
                    if(attacked(board,(whTurn?wKing:bKing),whTurn)){
                        board[sq[1]][sq[0]] = board[sq2[1]][sq2[0]];
                        board[sq2[1]][sq2[0]] = t2;
                        board[sq[1]][sq2[0]] = t1;
                        System.out.println("You are attacked");
                        continue;
                    }
                    printMas(board);
                    whTurn = !whTurn;
                    enPas[0] = enPas[1] = 0;
                    if (board[sq2[1]][sq2[0]] == '♙' || board[sq2[1]][sq2[0]] == '♟' && Math.abs(sq2[1]-sq[1]) == 2){
                        enPas[1] = (byte)((sq2[1]+sq[1])/2);
                        enPas[0] = sq2[0];
                    }
                }
                else
                    System.out.println("Invalid move");


            }
            else if(input.equals("exit"))
                break;
        }

    }
}