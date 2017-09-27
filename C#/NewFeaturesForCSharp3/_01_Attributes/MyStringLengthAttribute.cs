using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewFeaturesForCSharp3._01_Attributes
{
    // 用户自定义的带可选名参数的MyStringLengthAttribute特性类。
    // 该特性通过AttributeUsage限制它只能用在属性和字段上。
    [AttributeUsage(AttributeTargets.Property|AttributeTargets.Field)]
    public sealed class MyStringLengthAttribute : Attribute
    {
        public MyStringLengthAttribute(string displayName, int maxLength)
        {
            this.MaxLength = maxLength;
            this.DisplayName = displayName;
        }
        
        // 显示的名称，对外是只读的，所以不能通过可选参数来赋值，必须在构造函数中对其初始化。
        public string DisplayName { get; private set; }

        // 长度最大值，对外是只读的，所以不能通过可选参数来赋值，必须在构造函数中对其初始化。
        public int MaxLength { get; private set; }

        // 错误信息，标注时可作为可选名参数来使用。
        public string ErrorMessage { get; set; }

        // 长度最小值，标注时可作为可选命名参数来使用。
        public int MinLength { get; set; }
    }
}
