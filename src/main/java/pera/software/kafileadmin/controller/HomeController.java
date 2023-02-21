package pera.software.kafileadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pera.software.kafileadmin.client.dto.request.CreateMessageRequest;
import pera.software.kafileadmin.data.enums.ToastType;

import java.util.Objects;

@Controller
public class HomeController {
    private final FormController formController;

    public HomeController(FormController formController) {
        this.formController = formController;
    }

    @GetMapping("/")
    String index(Model model) {
        model.addAttribute("activePage", "home");
        return "pages/index";
    }

    @GetMapping("/blank")
    String blank(Model model) {
        model.addAttribute("activePage", "blank");
        model.addAttribute("activeToggle", "layouts");
        return "pages/layouts-blank";
    }

    @GetMapping("/account")
    String accountSettings(Model model) {
        model.addAttribute("activePage", "account");
        model.addAttribute("activeToggle", "account");
        return "pages/pages-account-settings-account";
    }

    @GetMapping("/login")
    String login(Model model) {
        model.addAttribute("activePage", "login");
        model.addAttribute("activeToggle", "auth");
        return "pages/auth-login-basic";
    }

    @GetMapping("/forgot-password")
    String forgotPassword(Model model) {
        model.addAttribute("activePage", "forgot-password");
        model.addAttribute("activeToggle", "auth");
        return "pages/auth-forgot-password-basic";
    }

    @GetMapping("/register")
    String register(Model model) {
        model.addAttribute("activePage", "register");
        model.addAttribute("activeToggle", "auth");
        return "pages/auth-register-basic";
    }

    @GetMapping("/error-page")
    String error(Model model) {
        model.addAttribute("activePage", "error-page");
        model.addAttribute("activeToggle", "misc");
        return "pages/pages-misc-error";
    }

    @GetMapping("/maintenance")
    String maintenance(Model model) {
        model.addAttribute("activePage", "maintenance");
        model.addAttribute("activeToggle", "misc");
        return "pages/pages-misc-under-maintenance";
    }

    @GetMapping("/toasts")
    String toasts(Model model) {
        model.addAttribute("activePage", "toasts");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-toasts";
    }

    @GetMapping("/horizontal-form")
    String horizontalForm(Model model) {
        model.addAttribute("activePage", "horizontal-form");
        model.addAttribute("activeToggle", "forms");

        if (model.getAttribute("message") == null) {
            model.addAttribute("message", CreateMessageRequest.builder().build());
        }

        return "pages/form-layouts-horizontal";
    }

    @PostMapping("/horizontal-form/save")
    public String saveMessageHorizontal(CreateMessageRequest message, RedirectAttributes redirectAttributes) throws InterruptedException {
        ResponseEntity<Object> result = formController.saveMessage(message);

        redirectAttributes.addFlashAttribute("visible", true);

        if (result.getStatusCode().value() == 200) {
            redirectAttributes.addFlashAttribute("type", ToastType.SUCCESS);
            redirectAttributes.addFlashAttribute("title", "Başarılı");
            redirectAttributes.addFlashAttribute("content", "Mesaj başarıyla gönderildi.");
        } else {
            redirectAttributes.addFlashAttribute("type", ToastType.WARNING);
            redirectAttributes.addFlashAttribute("title", "Hata");
            redirectAttributes.addFlashAttribute("content", "Mesaj gönderilemedi. Lütfen tekrar deneyiniz.");
            redirectAttributes.addFlashAttribute("message", message);
        }

        return "redirect:/horizontal-form";
    }

    @GetMapping("/tables")
    String tables(Model model) {
        model.addAttribute("activePage", "tables");
        return "pages/tables-basic";
    }

    @GetMapping("/cards")
    String cards(Model model) {
        model.addAttribute("activePage", "cards");
        return "pages/cards-basic";
    }

    @GetMapping("/perfect-scrollbar")
    String perfectScrollBar(Model model) {
        model.addAttribute("activePage", "perfect-scrollbar");
        model.addAttribute("activeToggle", "extended-ui");
        return "pages/extended-ui-perfect-scrollbar";
    }

    @GetMapping("/text-divider")
    String textDivider(Model model) {
        model.addAttribute("activePage", "text-divider");
        model.addAttribute("activeToggle", "extended-ui");
        return "pages/extended-ui-text-divider";
    }

    @GetMapping("/vertical-form")
    String verticalForm(Model model) {
        model.addAttribute("activePage", "vertical-form");
        model.addAttribute("activeToggle", "forms");

        if (model.getAttribute("message") == null) {
            model.addAttribute("message", CreateMessageRequest.builder().build());
        }

        return "pages/form-layouts-vertical";
    }

    @PostMapping("/vertical-form/save")
    public String saveMessageVertical(CreateMessageRequest message, RedirectAttributes redirectAttributes) throws InterruptedException {
        ResponseEntity<Object> result = formController.saveMessage(message);

        redirectAttributes.addFlashAttribute("visible", true);

        if (result.getStatusCode().value() == 200) {
            redirectAttributes.addFlashAttribute("type", ToastType.SUCCESS);
            redirectAttributes.addFlashAttribute("title", "Başarılı");
            redirectAttributes.addFlashAttribute("content", "Mesaj başarıyla gönderildi.");
        } else {
            redirectAttributes.addFlashAttribute("type", ToastType.WARNING);
            redirectAttributes.addFlashAttribute("title", "Hata");
            redirectAttributes.addFlashAttribute("content", "Mesaj gönderilemedi. Lütfen tekrar deneyiniz.");
            redirectAttributes.addFlashAttribute("message", message);
        }

        return "redirect:/vertical-form";
    }

    @GetMapping("/basic-inputs")
    String basicInputs(Model model) {
        model.addAttribute("activePage", "basic-inputs");
        model.addAttribute("activeToggle", "form-elements");
        return "pages/forms-basic-inputs";
    }

    @GetMapping("/input-groups")
    String inputGroups(Model model) {
        model.addAttribute("activePage", "input-groups");
        model.addAttribute("activeToggle", "form-elements");
        return "pages/forms-input-groups";
    }

    @GetMapping("/boxicons")
    String boxIcons(Model model) {
        model.addAttribute("activePage", "boxicons");
        return "pages/icons-boxicons";
    }

    @GetMapping("/container")
    String container(Model model) {
        model.addAttribute("activePage", "container");
        model.addAttribute("activeToggle", "layouts");
        return "pages/layouts-container";
    }

    @GetMapping("/fluid")
    String fluid(Model model) {
        model.addAttribute("activePage", "fluid");
        model.addAttribute("activeToggle", "layouts");
        return "pages/layouts-fluid";
    }

    @GetMapping("/without-navbar")
    String withoutNavbar(Model model) {
        model.addAttribute("activePage", "without-navbar");
        model.addAttribute("activeToggle", "layouts");
        return "pages/layouts-without-navbar";
    }

    @GetMapping("/without-menu")
    String withoutMenu(Model model) {
        model.addAttribute("activePage", "without-menu");
        model.addAttribute("activeToggle", "layouts");
        return "pages/layouts-without-menu";
    }

    @GetMapping("/connections")
    String connections(Model model) {
        model.addAttribute("activePage", "connections");
        model.addAttribute("activeToggle", "account");
        return "pages/pages-account-settings-connections";
    }

    @GetMapping("/notifications")
    String notifications(Model model) {
        model.addAttribute("activePage", "notifications");
        model.addAttribute("activeToggle", "account");
        return "pages/pages-account-settings-notifications";
    }

    @GetMapping("/accordion")
    String accordion(Model model) {
        model.addAttribute("activePage", "accordion");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-accordion";
    }

    @GetMapping("/alerts")
    String alerts(Model model) {
        model.addAttribute("activePage", "alerts");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-alerts";
    }

    @GetMapping("/badges")
    String badges(Model model) {
        model.addAttribute("activePage", "badges");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-badges";
    }

    @GetMapping("/buttons")
    String buttons(Model model) {
        model.addAttribute("activePage", "buttons");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-buttons";
    }

    @GetMapping("/carousel")
    String carousel(Model model) {
        model.addAttribute("activePage", "carousel");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-carousel";
    }

    @GetMapping("/collapse")
    String collapse(Model model) {
        model.addAttribute("activePage", "collapse");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-collapse";
    }

    @GetMapping("/dropdowns")
    String dropdowns(Model model) {
        model.addAttribute("activePage", "dropdowns");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-dropdowns";
    }

    @GetMapping("/footer")
    String footer(Model model) {
        model.addAttribute("activePage", "footer");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-footer";
    }

    @GetMapping("/list-groups")
    String listGroups(Model model) {
        model.addAttribute("activePage", "list-groups");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-list-groups";
    }

    @GetMapping("/modals")
    String modals(Model model) {
        model.addAttribute("activePage", "modals");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-modals";
    }

    @GetMapping("/navbar")
    String navbar(Model model) {
        model.addAttribute("activePage", "navbar");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-navbar";
    }

    @GetMapping("/offcanvas")
    String offcanvas(Model model) {
        model.addAttribute("activePage", "offcanvas");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-offcanvas";
    }

    @GetMapping("/pagination-breadcrumbs")
    String paginationBreadcrumbs(Model model) {
        model.addAttribute("activePage", "pagination-breadcrumbs");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-pagination-breadcrumbs";
    }

    @GetMapping("/progress")
    String progress(Model model) {
        model.addAttribute("activePage", "progress");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-progress";
    }

    @GetMapping("/spinners")
    String spinners(Model model) {
        model.addAttribute("activePage", "spinners");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-spinners";
    }

    @GetMapping("/tabs-pills")
    String tabsPills(Model model) {
        model.addAttribute("activePage", "tabs-pills");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-tabs-pills";
    }

    @GetMapping("/tooltips-popovers")
    String tooltipsPopovers(Model model) {
        model.addAttribute("activePage", "tooltips-popovers");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-tooltips-popovers";
    }

    @GetMapping("/typography")
    String typography(Model model) {
        model.addAttribute("activePage", "typography");
        model.addAttribute("activeToggle", "ui");
        return "pages/ui-typography";
    }

}
