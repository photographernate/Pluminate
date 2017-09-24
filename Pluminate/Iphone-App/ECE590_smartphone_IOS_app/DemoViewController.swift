//
//  DemoViewController.swift
//  ECE590_smartphone_IOS_app
//
//  Created by brdunn on 11/28/16.
//  Copyright © 2016 brdunn. All rights reserved.
//

import UIKit

class DemoViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        Timer.scheduledTimer(timeInterval: 0.4, target: self, selector: #selector(DemoViewController.fireTimer), userInfo: nil, repeats: true)
        
        // Do any additional setup after loading the view.
    }
    
    @IBAction func backTapped(_ sender: AnyObject) {
        self.dismiss(animated: true, completion: nil)
    }
    
    func fireTimer(){
        if(view.backgroundColor == UIColor.white){
            //view.backgroundColor = UIColor.purple
            view.backgroundColor = UIColor(red: 81/255, green: 40/255, blue: 136/255, alpha: 1.0)
        }else{
            view.backgroundColor = UIColor.white
        }
//        var randomRed:CGFloat = CGFloat(drand48())
//        
//        var randomGreen:CGFloat = CGFloat(drand48())
//        
//        var randomBlue:CGFloat = CGFloat(drand48())
//        
//        view.backgroundColor = UIColor(red: 23/255, green: 23/255, blue: 23/255, alpha: 1.0)

    }
    

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
