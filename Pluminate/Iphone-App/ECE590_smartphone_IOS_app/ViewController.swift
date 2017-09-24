//
//  ViewController.swift
//  ECE590_smartphone_IOS_app
//
//  Created by brdunn on 10/20/16.
//  Copyright © 2016 brdunn. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var ourLabel: UILabel!
    
    @IBAction func studentPressed(_ sender: AnyObject) {
        let alert = UIAlertController.init(title: "Student Section", message: "Verify that you are seated in the student section", preferredStyle: .alert)
        let okButton = UIAlertAction(title: "Ok", style: .default) { (action) in
            //button clicked code
        }
        let cancelButton = UIAlertAction(title: "Cancel", style: .default) { (action) in
            //button clicked code
        }
        alert.addAction(okButton)
        alert.addAction(cancelButton)
        present(alert, animated: true, completion: nil)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}

