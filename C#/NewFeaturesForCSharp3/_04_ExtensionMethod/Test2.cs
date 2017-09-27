using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewFeaturesForCSharp3._04_ExtensionMethod
{
    class Test2
    {
        static void Main(string[] args)
        {
            // 创建并初始化ShoppingCart实例，注入IEnumerable<Product>
            IEnumerable<Product> products = new ShoppingCart
            {
                Products = new List<Product>
                {
                    new Product { Name = "Kayak", Price = 275 },
                    new Product { Name = "Lifejacket", Price = 48.95M },
                    new Product { Name = "Soccer ball", Price = 19.50M },
                    new Product { Name = "Corner flag", Price = 34.95M }
                }
            };

            // 创建并初始化一个普通的Product数组
            Product[] productArray =
            {
                    new Product { Name = "Kayak", Price = 275 },
                    new Product { Name = "Lifejacket", Price = 48.95M },
                    new Product { Name = "Soccer ball", Price = 19.50M },
                    new Product { Name = "Corner flag", Price = 34.95M }
            };

            // 取得商品总价钱：用接口的方式调用TotalPrices扩展方法。
            decimal cartTotal = products.TotalPrices();

            // 取得商品总价钱：用普通数组的方式调用TotalPrices扩展方法。
            decimal arrayTotal = productArray.TotalPrices();

            Console.WriteLine("Cart Total: {0:c}", cartTotal);
            Console.WriteLine("Array Total: {0:c}", arrayTotal);
            Console.ReadKey();
        }
    }
}
