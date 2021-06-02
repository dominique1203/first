//
//  ViewController.swift
//  orderDrink
//
//  Created by dominique on 17/12/2019.
//  Copyright © 2019年 dominique. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    @IBOutlet weak var nameTextField: UITextField!
    
    @IBOutlet weak var drinkTextField: UITextField!
    
    @IBOutlet weak var priceTextField: UITextField!
    @IBOutlet weak var sugar: UISegmentedControl!
    @IBOutlet weak var ice: UISegmentedControl!
 
    @IBOutlet weak var orderBTN: UIButton!
    
    @IBAction func orderBTNpress(_ sender: Any) {
    
    
        if nameTextField.text != "" && drinkTextField.text != "" {
            checkSugarAndIce()
            sendToServer()
            
            nameTextField.text = ""
            drinkTextField.text = ""
            priceTextField.text = ""
            okAlert()
        }else{
            popAlert()
        }
    }
    @IBAction func orderBTNPress(_ sender: UIButton) {
    }
    
    let pickerView = UIPickerView()
    
    var drinkData: [drinkInfo] = []
    var chooseSugar:String?
    var chooseIce:String?

        

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
                orderBTN.layer.cornerRadius = 6
        
        nameTextField.becomeFirstResponder()
        getDrinkTxt()
        pickerView.delegate = self
        pickerView.dataSource = self
        
        drinkTextField.inputView = pickerView
        priceTextField.isUserInteractionEnabled = false
}
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return drinkData.count
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return drinkData[row].name
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        drinkTextField.text = drinkData[row].name
        priceTextField.text = "\(drinkData[row].price)"
    }
    
    //popAlert
    func popAlert(){
        let alert = UIAlertController(title: "訊息", message: "請填入完整訊息:)", preferredStyle: .alert)
        let okAction = UIAlertAction(title: "OK", style: .default, handler: nil)
        alert.addAction(okAction)
       present(alert,animated: true, completion: nil)
    }
    
    
    func okAlert(){
        let alert = UIAlertController(title: "訊息", message: "訂購成功!", preferredStyle: .alert)
        let okAction = UIAlertAction(title: "OK", style: .default, handler: nil)
        alert.addAction(okAction)
        present(alert,animated: true, completion: nil)
    }
    
    
    //甜度冰塊判斷
    func checkSugarAndIce(){
        switch sugar.selectedSegmentIndex {
        case 0:
            chooseSugar = "正常"
        case 1:
            chooseSugar = "少糖"
        case 2:
            chooseSugar = "半糖"
        case 3:
           chooseSugar = "微糖"
        case 4:
           chooseSugar = "無糖"
        default:
            break
        }
        
        switch ice.selectedSegmentIndex {
        case 0:
            chooseIce = "正常"
        case 1:
            chooseIce = "少冰"
        case 2:
            chooseIce = "微冰"
        case 3:
            chooseIce = "去冰"
        case 4:
            chooseIce = "熱"
        default:
            break
        }
    }
    
    // 讀取txt檔
    func getDrinkTxt(){

        if let url = Bundle.main.url(forResource: "DrinkList", withExtension: "txt"), let content = try? String(contentsOf: url){
            let listArray = content.components(separatedBy: "\n")
            for n in 0 ..< listArray.count{
                if n % 2 == 0{
                    let name = listArray[n]
                    if let price = Int(listArray[n + 1]){
                        drinkData.append(drinkInfo(name: name, price: price))
                    }
                }
            }
        }
    }
    // 將資料傳到後台
    func sendToServer(){
        let url = URL(string: "https://sheetdb.io/api/v1/e8yqtue3k9po5")
        var urlRequest = URLRequest(url: url!)
        
        urlRequest.httpMethod = "POST"
        urlRequest.setValue("application/json", forHTTPHeaderField: "Content-Type")
        
        let orderDictionary:[String: Any] = ["name": nameTextField.text!, "drink": drinkTextField.text!, "price": priceTextField.text!, "sugar": chooseSugar!, "ice" : chooseIce!]
        let orderData: [String: Any] = ["data": orderDictionary]
        
        do {
            let data = try JSONSerialization.data(withJSONObject: orderData, options: [])
            let task = URLSession.shared.uploadTask(with: urlRequest, from: data, completionHandler: { (retData, res,
                err) in
                if let returnData = retData, let dic = (try? JSONSerialization.jsonObject(with: returnData)) as? [String:String] {
                    print(dic)
                }
                
            })
            task.resume()
        }
        catch{
        }
    }
}





