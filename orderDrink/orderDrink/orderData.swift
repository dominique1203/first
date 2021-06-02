//
//  orderData.swift
//  orderDrink
//
//  Created by dominique on 18/12/2019.
//  Copyright © 2019年 dominique. All rights reserved.
//

import Foundation

struct drinkInfo {
    var name: String
    var price: Int
}

enum SugarInfo: String{
    case regular = "正常"
    case little = "少糖"
    case half = "半糖"
    case less = "微糖"
    case free = "無糖"
}

enum IceInfo: String{
    case regular = "正常"
    case little = "少冰"
    case less = "微冰"
    case free = "去冰"
    case got = "熱"
}
