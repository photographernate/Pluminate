//
//  TicketViewController.swift
//  ECE590_smartphone_IOS_app
//
//  Created by brdunn on 11/28/16.
//  Copyright © 2016 brdunn. All rights reserved.
//

import UIKit

class TicketViewController: UIViewController {

    @IBOutlet weak var sectionTF: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        sectionTF.becomeFirstResponder()
        // Do any additional setup after loading the view.
    }

    @IBAction func submitTapped(_ sender: AnyObject) {
    }
    
    @IBAction func backTapped(_ sender: AnyObject) {
        self.dismiss(animated: true, completion: nil)
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
