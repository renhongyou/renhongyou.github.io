using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewFeaturesForCSharp3._04_ExtensionMethod
{
    /// <summary>
    /// 定义一个静态类，用于实现扩展方法（注意：扩展方法必须定义在静态类中）
    /// </summary>
    public static class MyExtensionMethods
    {
        /// <summary>
        /// 计算商品总价钱
        /// </summary>
        public static decimal TotalPrices(this IEnumerable<Product> productEnum)
        {
            decimal total = 0;
            foreach (Product product in productEnum)
            {
                total += product.Price;
            }

            return total;
        }
    }
}
