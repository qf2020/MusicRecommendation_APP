package cjk.design.music.activity.login;

import android.app.Activity;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import cjk.design.music.R;


/**
 * @author: cjk
 * @date: 2021/12/9
 * @func:
 */
public class LoginAgrementView {
    private Activity activity;
    private TextView tvArrgement;

    public LoginAgrementView(Activity activity, TextView tvArrgement) {
        this.activity = activity;
        this.tvArrgement = tvArrgement;
    }

    /**
     * 用户协议
     */
    public void useAgrement() {
        tvArrgement.setText(activity.getString(R.string.login_consent_1));
        SpannableString clickString = new SpannableString(activity.getString(R.string.user_service));
        clickString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFF")), 0, clickString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        clickString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                new AccordDialog(activity,"用户协议\n" +
                        "本协议是您与享听客户端（简称“本客户端”）所有者（以下简称为“享听”）之间就享听客户端服务等相关事宜所订立的契约，请您仔细阅读本注册协议，您点击“注册”按钮后，本协议即构成对双方有约束力的法律文件。\n" +
                        "\n" +
                        "\n" +
                        "第1条本客户端服务条款的确认和接纳\n" +
                        "1.1. 本客户端的各项电子服务的所有权和运作权归享听所有。用户同意所有注册协议条款并完成注册程序，才能成为本客户端的正式用户。用户确认：本协议条款是处理双方权利义务的契约，始终有效，法律另有强制性规定或双方另有特别约定的，依其规定。\n" +
                        "1.2. 用户点击同意本协议的，即视为用户确认自己具有享受本客户端服务、下单购买等相应的权利能力和行为能力，能够独立承担法律责任。\n" +
                        "1.3. 如果您在18周岁以下，您只能在父母或监护人的监护参与下才能使用本客户端。\n" +
                        "1.4. 享听保留在中华人民共和国大陆地区法施行之法律允许的范围内独自决定拒绝服务、关闭用户账户、清除或编辑内容或取消订单的权利。\n" +
                        "第2条本客户端服务\n" +
                        "2.1. 享听通过互联网依法为用户提供互联网信息等服务，用户在完全同意本协议及本客户端规定的情况下，方有权使用本客户端的相关服务。\n" +
                        "2.2. 用户必须自行准备如下设备和承担如下开支：\n" +
                        "  （1）上网设备，包括并不限于电脑或者其他上网终端、调制解调器及其他必备的上网装置；\n" +
                        "  （2）上网开支，包括并不限于网络接入费、上网设备租用费、手机流量费等。\n" +
                        "第3条用户信息\n" +
                        "3.1. 用户应自行诚信向本客户端提供注册资料，用户同意其提供的注册资料真实、准确、完整、合法有效，用户注册资料如有变动的，应及时更新其注册资料。如果用户提供的注册资料不合法、不真实、不准确、不详尽的，用户需承担因此引起的相应责任及后果，并且享听保留终止用户使用享听各项服务的权利。\n" +
                        "3.2. 用户在本客户端进行购买活动时，涉及用户真实姓名/名称、通信地址、联系电话、电子邮箱等隐私信息的，本站将予以严格保密，除非得到用户的授权或法律另有规定，本站不会向外界披露用户隐私信息。\n" +
                        "3.3. 用户注册成功后，将产生用户名和密码等账户信息，您可以根据本客户端规定改变您的密码。用户应谨慎合理的保存、使用其用户名和密码。用户若发现任何非法使用用户账号或存在安全漏洞的情况，请立即通知本客户端并向公安机关报案。\n" +
                        "3.4. 用户同意，享听拥有通过邮件、短信电话等形式，向在本客户端注册、购买的用户发送订单信息、促销活动等告知信息的权利。\n" +
                        "3.5. 用户不得将在本站注册获得的账户借给他人使用，否则用户应承担由此产生的全部责任，并与实际使用人承担连带责任。\n" +
                        "3.6. 用户同意，享听有权使用用户的注册信息、用户名、密码等信息，登陆进入用户的注册账户，进行证据保全，包括但不限于公证、见证等。").show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(activity.getResources().getColor(R.color.accord));
                ds.setUnderlineText(false);
            }
        }, 0, clickString.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvArrgement.append(clickString);
        tvArrgement.append(new SpannableString("和"));
        SpannableString clickStringPrivacy= new SpannableString(activity.getString(R.string.privacy_policy));
        clickStringPrivacy.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                new AccordDialog(activity,"欢迎您使用享听（\"我们\"）的产品和/或服务，我们非常重视和保护您的隐私信息和您的个人信息。 享听平台 是指由 【杭州享听健康管理有限公司】及其关联公司 享有所有权和/或运营权的【享听医生网站（www.dxy.com）】以及移动应用【享听医生 APP】/【享听医生小程序】等平台的统称。\n" +
                        "\n" +
                        "本隐私政策适用于您通过任何方式使用享听平台提供的全部产品和/或服务（本隐私政策中统称为享听平台服务）的使用而提供或留存的信息，我们希望通过本隐私政策向您说明在您享听医生平台服务时，我们是如何收集、使用、保存、共享和转让这些信息，以及我们将为您提供访问、更新、删除、保护以及注销这些信息的方式。\n" +
                        "\n" +
                        "请您在继续使用享听产品或服务前务必认真仔细阅读并确认充分理解本隐私政策全部规则和要点，并确认您已经充分理解本隐私政策所写明的内容（重点内容我们均用粗体或下划线方式表示）。一旦您选择使用或在我们更新本隐私政策后（我们会及时提示您更新的情况）继续使用我们的产品和服务，即视为您同意本隐私政策（含更新版本）的全部内容，同意我们按本隐私政策收集、使用、共享和处理您的相关信息。\n" +
                        "如您对本隐私政策有任何疑问，可通过本隐私政策第八章节【如何联系我们】或者享听 APP 中的【联系客服】向我们进行反馈。如您不同意相关协议或其中的任何条款的，您应停止使用我们的产品和/或服务。\n" +
                        "\n" +
                        "本隐私政策帮助您了解以下内容：\n" +
                        " 一. 我们如何收集和使用您的个人信息\n" +
                        "二. 我们如何使用 Cookie 和其他追踪技术；\n" +
                        "三. 我们如何共享、转让、公开披露您的个人信息；\n" +
                        "四. 我们如何存储保存和保护您的个人信息；\n" +
                        "五. 您的权利；\n" +
                        "六. 我们如何处理未成年人的个人信息；\n" +
                        "七. 如何更新本政策；\n" +
                        "八. 如何联系我们；\n" +
                        "九. 争议解决；\n" +
                        "十. 定义和名词解释。\n" +
                        "\n" +
                        "我们深知个人信息对您的重要性，并会尽全力保护您的个人信息安全可靠。我们致力于维持您对我们的信任，恪守以下原则，保护您的个人信息：权责一致原则、目的明确原则、选择同意原则、最少够用原则、确保安全原则、主体参与原则、公开透明原则等。同时，我们承诺将按业界成熟的安全标准，采取相应的安全保护措施来保护您的个人信息。\n" +
                        "\n" +
                        "一、我们如何收集和使用您的个人信息\n" +
                        "\n" +
                        "前言：\n" +
                        "\n" +
                        "个人信息是指以电子或者其他方式记录的能够单独或者与其他信息，结合识别特定自然人身份或者反映特定自然人活动情况的各种信息。如姓名、出生日期、身份证件号 码、个人生物识别信息、住址、通信通讯联系方式、通信记录和内容、账号密码、财产信息、征信信息、行踪轨迹、住宿信息、健康生理信息、交易信息等。具体的关于个人信息的定义以及本隐私政策将涉及到的个人信息，将通过本隐私政策如下具体内容的阐述以及第十章节的定义和名词解释进行明确。\n" +
                        "我们会根据本隐私政策的约定，为实现我们的产品和/或服务功能而对所收集的个人信息进行使用。\n" +
                        "在收集您的个人信息后，我们将通过技术手段对数据进行去标识化处理，去标识化处理的信息将不含可识别到具体个人身份的信息。请您了解并同意，在此情况下我们有权使用已经去标识化的信息；并在不透露您个人信息的前提下，我们有权对用户数据库进行分析并予以商业化的利用。\n" +
                        "我们会对我们的产品与 / 或服务使用情况进行统计，并可能会与公众或第三方共享这些统计信息，以展示我们的产品与 / 或服务的整体使用趋势。但这些统计信息将进行匿名化处理，不包含您的任何身份识别信息。\n" +
                        "在您选择公开您的问答内容而需展示您的个人信息时，我们会采用打码、替换、匿名处理方式对您的信息进行脱敏，使您不可被直接识别以保护您的信息安全。\n" +
                        "我们将在以下情况或出于以下目的，收集和使用您的个人信息：\n" +
                        "\n" +
                        "（一）注册、登录\n" +
                        "\n" +
                        "1、您账号注册成功后，您可以补充您的头像、昵称、性别、城市、生日、个性签名以及您实名验证的相关信息，这些信息均属于您的\"账号信息\"，同时如果您提供该等信息，将有助于更好地帮助我们提供更好的服务和体验。但如果您不提供这些补充和额外信息，将不会影响使用本服务的基本功能。\n" +
                        "\n" +
                        "2、注册会员服务：我们会根据您的享听平台账户使用情况及平台设置的账户等级计算规则确定您当前的等级，并为您提供相应账户等级所对应的基本权益。如果您选择提供真实姓名、性别、出生日期、居住地、昵称、头像等非注册必须的个人资料，我们可以为您提供会员生日特权等更加个性化的会员服务。其中，如果您提供昵称和头像的，您的昵称、头像将公开显示。\n" +
                        "\n" +
                        "3、实名认证：您可以根据认证要求提供相应的身份信息（身份证、护照、户口簿及其他身份证件信息）、生物识别特征（静态或动态的面部特征）以完成实名认证。若您需使用账户增强保护功能，除上述实名认证方式外，您还可以选择开启声纹、指纹密保或者扫脸登录，提供声纹、指纹、虹膜识别信息或者面部特征信息。\n" +
                        "\n" +
                        "4、授权登录：我们可能经您同意后向第三方共享您的账户信息（头像、昵称及其他页面提示的信息），使您可以便捷地实现第三方账户的注册或第三方处直接登录。此外，我们可能会根据您的授权从微信、支付宝等第三方处获取您的第三方账户信息，并与您的享听平台账户进行绑定，使您可在第三方处直接登录、使用我们的产品及/或服务。我们将在您授权同意的范围内使用您的相关信息。\n" +
                        "\n" +
                        "5、如果您已拥有享听平台账户，我们可能会在享听平台服务中显示您的上述个人信息（实人认证仅显示认证是否通过的结果），以及您在享听平台上或与享听平台账户相关联的产品和服务中执行的操作，包括通过享听平台账户集中展示您的个人资料、优惠权益、交易订单。我们会尊重您对享听平台服务和享听平台账户设置所做的选择。\n" +
                        "\n" +
                        "6 、如您不注册账号，可通过微信和 Apple 登录这两种第三方平台授权登录，我们仍然需要绑定您的电话号码，通过电话号码来验证您的身份是否有效。\n" +
                        "\n" +
                        "7 、如您拒绝提供手机号码或身份证号码进行实名验证以及上述个人敏感信息的，将可能导致注册不成功，您可以退出注册页面后进入享听平台，仅浏览平台内的相关信息内容，但不可进行任何其它的操作或接受平台提供的核心服务等（如下第（二）节我们为您提供的产品和 / 或服务中的相关内容）。").show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(activity.getResources().getColor(R.color.accord));
                ds.setUnderlineText(false);
            }
        }, 0, clickStringPrivacy.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvArrgement.append(clickStringPrivacy);
        tvArrgement.append(activity.getString(R.string.login_consent_2));
        //开始响应点击事件
        tvArrgement.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
