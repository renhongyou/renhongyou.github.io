using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewFeaturesForCSharp3._05_Lambda
{
    /// <summary>
    /// 定义一个静态类，用于实现扩展方法
    /// </summary>
    public static class MyExtensionMethods
    {
        /// <summary>
        /// 商品查询器
        /// </summary>
        /// <param name="productEnum">扩展类型的实例引用</param>
        /// <param name="selectorParam">一个参数类型为Product，返回值为bool的委托</param>
        /// <returns>查询结果</returns>
        public static IEnumerable<Product> Filter(this IEnumerable<Product> productEnum, Func<Product, bool> selectorParam)
        {
            foreach (Product product in productEnum)
            {
                if (selectorParam(product))
                {
                    yield return product;
                }
            }
        }
    }
}
