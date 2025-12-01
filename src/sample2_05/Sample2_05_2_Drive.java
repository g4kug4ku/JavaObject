package sample2_05;
import sample2_05_1.Sample2_05_2_Car;

class Sample2_05_2_Drive {
	public static void main (String[] args) {
		
		//シナリオ①：車を場に登場させる（Sample2_05_2_Carクラスのインスタンス化）
		
		Sample2_05_2_Car       car1       = new Sample2_05_2_Car() ;
		Sample2_05_2_FireTruck fireTruck1 = new Sample2_05_2_FireTruck() ;
		
		
		//シナリオ②：paintメソッドの起動
		
		car1.paint( "BLACK" );
		fireTruck1.paint( "BLACK" );
		
		
		//シナリオ③：paintメソッドの起動
		
		//時速200km/hまで加速
		for(int i = 0 ; i < 200 ; i++){
			
			car1.accelerator();
			//オーバーライドしたサブクラスのacceleratorメソッドが呼び出される
			//メソッドを呼び出す時はサブクラスから探し始める
			//だからサブクラスのacceleratorメソッドが呼び出される
			fireTruck1.accelerator();
			
		}
		
		
		//シナリオ④：各フィールドの確認
		System.out.println("▼シナリオ④：各フィールドの確認------") ;
		
		System.out.println("car1.color       ："       + car1.getColor() ) ;
		System.out.println("car1.speed       ："       + car1.getSpeed() ) ;
		//fireTruck1.accelerator();のところ同様、まずサブクラスにgetColorメソッドがあるか探す
		//サブクラスにはgetColorメソッドは無いからスパークラスを探し、getColorメソッドを見つけて実行する
		System.out.println("fireTruck1.color ：" + fireTruck1.getColor() ) ;
		System.out.println("fireTruck1.speed ：" + fireTruck1.getSpeed() ) ;
		
	}
}
