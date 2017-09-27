using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewFeaturesForCSharp3._01_Attributes
{
    // 应用自定义MyStringLength特性于Order类的OrderID属性之上。MinLength和ErrorMessage是命名参数。
    public class Order
    {
        [MyStringLength("订单号", 6, MinLength = 3, ErrorMessage = "{0}的长度必须在{1}和{2}之间，请重新输入！")]
        public string OrderID { get; set; }
    }
}
